@CrossOrigin
    @RequestMapping("/getanalysis")
    public JsonArray getAnalysis() {

        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DNA_StudyDAO dao = context.getBean(DNA_StudyDAO.class);
        ArrayList<DNA_Study> result = (ArrayList<DNA_Study>) dao.findAll();
        JsonArrayBuilder datasourcesBuilder = Json.createArrayBuilder();
        for(DNA_Study study : result) {
            datasourcesBuilder
            .add(Json.createObjectBuilder()
                .add("name", study.getName())
                .add("description", study.getDescription())
                .add("size", String.valueOf(study.getSamples().size())));
        }
        return datasourcesBuilder.build();
}