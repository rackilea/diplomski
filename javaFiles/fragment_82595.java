@Path("/sendpassword")
    public class SendPassword {
        @Autowired
        EmailService emailService;
        @GET
        @Produces("application/json")
        public String sendPasswordToEmail(@QueryParam("empid") String empid)
                throws JSONException
        {