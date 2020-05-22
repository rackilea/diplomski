@GetMapping("/person/{name}")
@ResponseBody
public String person(
    @PathVariable("name") String name, 
    @MatrixVariable("age") int age,
    @MatrixVariable("height") int height) {

    // ...
}