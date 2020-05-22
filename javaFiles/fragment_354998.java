@RequestMapping(value="/json/add", method=RequestMethod.POST)
    public @ResponseBody void addB(@RequestBody B b) { 

        // you can get your address object here or can save it directly
       Address address = b.getAddress();

        BManager.save(b);           
    }