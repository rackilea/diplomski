@RequestMapping(value="/json/add", method=RequestMethod.POST)
    public @ResponseBody void addB(@RequestBody B b) { 

        A a = AManager.findByAddress(123456);

        if(a == null)
        {
          // you need to create a new obj in here

           a = new A();
           a.setId(anyId);
            //remain code
        }

         //then set in here  
        B.setA(a); // I must be from JSON, not static!
        BManager.save(b);           
    }