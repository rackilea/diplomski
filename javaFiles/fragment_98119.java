fun main(args: Array<String>) {
    val gson = GsonBuilder().registerTypeAdapter(TodoAction::class.java, TodoActionSerializer())
        .create()
    val jsonString = "{type: 'ADD_TODO',payload: {text: 'Do something.'}}"
    val todoAction = gson.fromJson(jsonString, TodoAction::class.java)

    print(todoAction)
}


class TodoAction(
    val type: String,
    val payload: JsonObject
)


class TodoActionSerializer : JsonSerializer<TodoAction> {
    override fun serialize(p0: TodoAction?, p1: Type?, p2: JsonSerializationContext?): JsonElement {
        val response = JsonObject()
        response.addProperty("type", p0!!.type)
        response.add("payload", p0.payload)
        return response
    }

}