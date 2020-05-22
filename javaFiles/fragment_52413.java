val newDataPair = newRecords.map{t =>                
    val p = (new Gson()).fromJson(t, classOf[MyPerson])
    val nameAgeKey = p.getName + "_" + p.getAge
    val value = (p.getNationality(), t)
    (nameAgeKey.toLowerCase(), value)
}