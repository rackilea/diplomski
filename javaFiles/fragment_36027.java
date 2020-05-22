@RequestMapping(
        value="/{id}",
        method=RequestMethod.PUT,
        consumes={MediaType.APPLICATION_JSON_VALUE}
)
public @ResponseBody ResponseEntity<T> update(@PathVariable ID id, 
    @RequestParam String token, @RequestBody T json) {
        doFancyStuff();
}