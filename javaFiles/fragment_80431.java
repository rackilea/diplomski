@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Path("")
public String postV1Default(EquipmentMetricsRequest theRequest) {
   List<EquipmentMetricsResponse> retVal ...
   ...  
   return new Gson().toJson(retVal);  
}