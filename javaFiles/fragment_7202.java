public class JSONParam {
    private DataTransferObject dto;

    public JSONParam(String json) throws WebApplicationException {
        try {
            // convert json string DataTransferObject and set dto
        }
        catch (JSONException e) {
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
                    .entity("Couldn't parse JSON string: " + e.getMessage())
                    .build());
        }
    }

    public DataTransferObject getDTO() {
        return dto;
    }
}