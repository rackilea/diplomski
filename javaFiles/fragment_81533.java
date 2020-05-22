@PostMapping("/api/v1/save")
public String save_commodities_user_predict_data(@RequestBody Map<String, String> jsonData) {

    for (Entry<String,String> pair : jsonData.entrySet()){
        //iterate over the pairs
        System.out.println(pair.getKey()+" "+pair.getValue());
    }
}