@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public @ResponseBody ResponseStatus testMethod(HttpServletRequest request,
            @RequestBody TestList testList)
            throws Exception {
..............
}