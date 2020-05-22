@RequestMapping(value = urlPattern , method = RequestMethod.POST)

public @ResponseBody Test addNewWorker(@RequestBody Test jsonString) {

    //do business logic
    return test;
}