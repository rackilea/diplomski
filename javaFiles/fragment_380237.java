//PUT method #1
@RequestMapping(method=RequestMethod.PUT, value="/foo", headers="returnType=Foo")
public @ResponseBody Foo updateFoo(@RequestBody Foo foo) {
    fooService.update(foo);
}

//PUT method #2
@RequestMapping(method=RequestMethod.PUT, value="/foo", headers="returnType=FooExtra")
public @ResponseBody FooExtra updateFoo(@RequestBody FooExtra fooExtra) {
    fooService.update(fooExtra);
}