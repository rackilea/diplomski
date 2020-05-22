@PostMapping(value = "/v1/notification")
public ResponseEntity handleNotifications(@RequestBody Map<String,String> keyValuePairs) {
    // here you can use keyValuePairs
    // you can process some specific key like
    String value = keyValuePairs.get("someSpecificKey");

    return ResponseEntity.ok(value);
}