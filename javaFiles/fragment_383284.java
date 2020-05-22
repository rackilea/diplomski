@RequestMapping(value = "insertOperation", method = RequestMethod.POST)

    public Map<String, String> insertOperation(
        @RequestParam String action,
        @RequestParam String datacenter, 
        @RequestParam String node, 
        @RequestParam String data
    ) {}