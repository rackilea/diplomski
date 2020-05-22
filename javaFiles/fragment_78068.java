@RequestMapping(value = "/ex/foos/{fooid}/bar/{barid}")
@ResponseBody
public String getPathValues
  (@PathVariable long fooid, @PathVariable long barid) {
    return "Get a specific Bar with id=" + barid + " from a Foo with id=" + fooid;
}