@RequestMapping(value="/test",produces=MediaType.APPLICATION_JSON_VALUE,method= {RequestMethod.POST})
    public String post(@RequestBody Outer outer) {
        LOGGER.debug("Getting the logged in cutomer details" +outer);
        Customer customer1 = new Customer("1", "customer1", "Sample@cust1.com");
        LOGGER.info("The customer details are " + customer1);
        return "done!!";
    }