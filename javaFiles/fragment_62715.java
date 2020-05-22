@Path("/")
        public class Employee {
            @Inject
            static EmployeeService employeeService;

            @GET
            @Path("/xml")
            @Produces({ "application/xml" })
            @RolesAllowed({"employee"})
            public String getHelloWorldXML() {
                return "<xml><result>" +    employeeService.createHelloMessage("Employee") + "</result></xml>";
            }

        }