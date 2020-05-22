@ModelAttribute("parent")
public Parent createChild(@RequestParam("type") String type) {
    if ("foo".equals(type)) return new Foo();
    else if ("bar".equals(type)) return new Bar();
    else return null;
}