fun readCSVFile(filePath: String): List<String> {
    val reader = FileReader(filePath)
    val records = CSVFormat.DEFAULT.parse(reader)
    val rows = mutableListOf<String>()

    var output = StringBuilder("")
    records.forEach() {
        output = StringBuilder("")
        val size = it.size()
        for (i in 0 until it.size()-1) {
            output = output.append(it.get(i) + ",")
        }
        output.deleteCharAt(output.length - 1)
        rows.add(output.toString())
    }
    return rows
}