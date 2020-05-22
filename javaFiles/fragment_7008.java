getCityInfo("Chicago", 
{
    var cityName = it.getString("name")
    var main = it.getJSONObject("main")
    var temp: Double = main.getDouble("temp")
    //getting the rest of the info

    var currTemp = CurrentTemperature(temp,press,humidity,min,max,state,desc,icon)
    var city = City(name, currTemp)

    setCity(city) // TODO: implement method within Activity 
})