@RequestMapping(value = "/items/add", method = RequestMethod.POST)
public ResponseEntity addGDT(@RequestBody String data, Principal principal) {

    if ((RequestCounter.get() % 100) == 0) {
        RequestCounter.addFailed();
        return ResponseEntity.notFound().build();
    } else {
        RequestCounter.add();
        return ResponseEntity.ok().build();
    }
}