@PostMapping("/number")
public Integer getNumber(@RequestHeader Map<String, String> headers) {

    if (Optional.ofNullable(headers.get("no")).isPresent()){
        //...
    }
    else if (Optional.ofNullable(headers.get("number")).isPresent())
    {
        //...
    }

}