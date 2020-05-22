public static PolicyDMO createPolicyDMO(PolicyDTO policydto){

    PolicyDMO policyDMO = null;
    if (policydto != null) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            policyDMO = mapper.readValue(mapper.writeValueAsString(policydto), PolicyDMO.class);
        } catch (JsonGenerationException e)
          {
             e.printStackTrace();
          } catch (JsonMappingException e)
          {
             e.printStackTrace();
          } catch (Exception e) {

        }
    } else {
        LOGGER.error("unable to parse the object that is NULL");
    }
    return policyDMO;
}