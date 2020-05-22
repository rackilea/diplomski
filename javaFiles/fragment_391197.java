@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object") 
class SearchResult {
    public String display_name; //ex: "Málaga, Provincia de Málaga, Andalusia, Spain"
    public String lat, lon; //ex: lat: "36.7210805", lon: "-4.4210409"
    public double importance; //ex: 0.73359836669253
}