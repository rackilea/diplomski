@RequestMapping(value = "updateOperation", method = RequestMethod.POST)
        public Map<String, String> updateOperation(@RequestParam String action,
                                                  @RequestParam String datacenter, 
                                                  @RequestParam String node, 
                                                  @RequestParam String data,
                                                  @RequestParam String conf,
                                                  ) {}