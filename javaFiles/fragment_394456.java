@RequestMapping(value = "/nrConturi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Cerere> setNrConturi(@RequestParam(value = "jud", defaultValue = "") String jud,
                                     @RequestParam(value = "aplic", defaultValue = "") String aplic,
                                     @RequestParam(value = "oper", defaultValue = "") String oper) {
        LOG.debug(">>>>> {}", jud);
        LOG.debug(">>>>> {}", aplic);
        LOG.debug(">>>>> {}", oper);

        List<Cerere> list = cerereRepository.nrConturi(jud, aplic, oper);
        return list;
}