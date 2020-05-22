// Helper extension property for easily mapping Strings
// to their enum CategoryType
val String.catType: CategoryType?
    get() = CategoryType.values().find { it.toString() == this }

fun deserialize(json: String): Map<CategoryType, List<Category>> {
    // initialize the return value
    val categories = CategoryType.values().map { it to (mutableListOf<Category>()) }.toMap()
    // parse json
    val input = Gson().fromJson(json, com.google.gson.JsonObject::class.java)


    // accumulate itemLists for constructing Categories later
    // those lists will be looked up via CategoryType and CategoryId
    val itemLists = CategoryType.values().map { it to (mutableMapOf<String, MutableList<Item>>()) }.toMap()
    input["items"].asJsonArray.map { it.asJsonObject }.forEach { item ->
        // read properties for item
        val types = item.entrySet().filter { it.key.startsWith("type") }.map { it.value.asString.catType }
        val ids = item.getAsJsonArray("categoryIds").map { it.asString }
        val name = item["name"].asString
        val item_id = item["id"].asString
        val data = item["data"]
        //
        types.forEach { type ->
            type?.let {
                val itemObj = Item(name, item_id, type, data, ids.toTypedArray())
                ids.forEach { id ->
                    with(itemLists[type]!!) {
                        if (!this?.containsKey(id)) this[id] = mutableListOf(itemObj)
                        else this[id]?.add(itemObj)
                    }
                }
            }
        }
    }

    // go through all categories and create appropriate objects
    input["categories"].asJsonArray.map { it.asJsonObject }.forEach { cat ->
        val id = cat["id"].asString
        val name = cat["name"].asString
        val types = cat.entrySet().filter { it.key.startsWith("type") }.map { it.value.asString.catType }
        types.forEach { type ->
            type?.let {
                categories[type]
                        ?.add(Category(
                                name = name,
                                id = id,
                                type = type,
                                items = itemLists[type]?.get(id) ?: listOf()))
            }
        }
    }

    return categories
}