// Json Parsing Object
        fun parse(name: String): JsonObject {
            val parser = Parser()
            val stringBuilder: StringBuilder = StringBuilder(name)
            val json: JsonObject = parser.parse(stringBuilder) as JsonObject
            return json
        }