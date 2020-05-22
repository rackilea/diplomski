@RequestMapping("/foo/bar/{id}")
@ResponseBody
@MessageMapping("/foo/bar/{id}")
@SendTo("/baz")
public Answer method(
    @PathVariable @DestinationVariable int id,
    @RequestBody Message message,
    @RequestHeader("foo") @Header("foo") String foo) {