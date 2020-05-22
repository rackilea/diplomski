@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name
                            ,@RequestParam(value="test", defaultValue="TEST value") String test
                            ) {
         Greeting greeting = null;
        if(name.equals("User")) {
             greeting = new Greeting(String.format(templateForName, name));
        } else if(test.equals("test"))  {
              greeting = new Greeting(String.format(templateForTest, test));
        }
        return greeting;
    }