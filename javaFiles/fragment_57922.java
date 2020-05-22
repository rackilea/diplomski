@PostMapping(
        value = SURVEY_RESULTS_ENDPOINT, 
        produces = { "application/hal+json", "application/json" }
    )   
public Resource<SurveyResult> createSurveyResults(@RequestBody Body body) {

}