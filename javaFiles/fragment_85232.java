fun main(args: Array<String>) {
    addObject("example.json", "GENERAL", arrayOf(arrayOf("POS_X", "2"), arrayOf("POS_Y", "4")))
}


fun addObject(path: String, name: String, value: String) {
    val gson = Gson()
    val reader: FileReader = FileReader(File(path))
    val type = object : TypeToken<Map<String, String>>() {}.type
    System.out.println("Type: " + type.toString())
    val existingJson = gson.fromJson<Map<String, String>>(JsonReader(reader), type)
    System.out.println("Existing Json: ${existingJson}")
    val newJsonMap = existingJson.plus(Pair(name, value))
    FileWriter(File(path)).use(
        { writer -> writer.write(gson.toJson(newJsonMap)) }
    )
}

fun arrayOf(s1: String, s2: String): String {
    return "[$s1, $s2]"
}