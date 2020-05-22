@PatchMapping("/update")
public String updateOnlyIfFieldIsPresent1(@RequestBody Map<String, Object> requestBody) {

    if (requestBody.get("name") != null) {
        return "Success" + requestBody.get("name"); 
    } else {
        return "Success" + "name attribute not present in request body";    
    }


}