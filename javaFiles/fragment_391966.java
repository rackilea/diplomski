List<Validator> validators = new ArrayList<Validator>();
validators.add(new Validator(){ 
    public boolean validate(Request req, Response res) { ValidationLibrary.validateUsername(req,res); } 
});
validators.add(new Validator(){ 
    public boolean validate(Request req, Response res) { ValidationLibrary.validateSecurity(req,res); } 
});