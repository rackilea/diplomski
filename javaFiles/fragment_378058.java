private fun getNumbers(string:String){
        val p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+?")
        val numbers: MutableList<String> = ArrayList()
        val m: Matcher =
            p.matcher(string)
        while (m.find()) {
            numbers.add(m.group())

        }
        println(numbers)
    }