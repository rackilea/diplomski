@RequestMapping("/viewAllData")
    public ModelAndView viewData() {
        String dataTable;
        List<Passport> passports = dbQuery.getAllDataPassports();
        // List to whatever it needs to be
        return new ModelAndView("viewAllData", "passports", passports);
    }