private final String pname = "";
    private final String patno = "";

    @RequestMapping("/patientinfo")
    @ResponseBody
    public GetPatientInfo getPatientInfo (@RequestParam String ssnum){
        return new GetPatientInfo(pname, patno, ssnum);
    }