@RequestMapping(value = "/rest/class1", method = RequestMethod.POST, consumes = { "application/json" })
public void postData(@RequestBody Class1 objOfClass1){
    store(objOfClass1)
}

@RequestMapping(value = "/rest/class2", method = RequestMethod.POST, consumes = { "application/json" })
public void postData(@RequestBody Class2 objOfClass2){
    store(objOfClass2)
}