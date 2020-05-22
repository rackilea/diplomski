@GET
      @Path("get-policy/{policyNumber: .*}")
      @Produces(MediaType.APPLICATION_XML)
      public String getPolicyIndividual(
        @PathParam("policyNumber")String policyNumber)
        {
          doSomething(policyNumber, "", "");
        }

    @GET
    @Path("get-policy/{policyNumber: .*}/{endorsement: .*}")
    @Produces(MediaType.APPLICATION_XML)
    public String getPolicyIndividual(
            @PathParam("policyNumber")String policyNumber, 
            @PathParam("endorsement")String endorsement)
            {
              doSomething(policyNumber,endorsement, "");
            }