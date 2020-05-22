@RequestMapping(value = "/home.web/{statechoice}", method = RequestMethod.GET, produces = { "application/xml",
            "application/json" })
    @ResponseBody
    public void getUSCity(@PathVariable("statechoice") String statechoice) {

        System.out.println("In getUSCity" + statechoice);

    }