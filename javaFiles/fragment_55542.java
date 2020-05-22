public class Rest{
    public static void main(String[] args) {
        String json = "{'CBE_GetNewSessionResponse': {" +
                "'CBE_GetNewSessionResult': '10016-300-0000022151'}" +
                "}";
        Gson gson = new Gson();
        Data data = gson.fromJson(json, Data.class);
        System.out.println(data.getCBE_GetNewSessionResponse().getCBE_GetNewSessionResult());
    }
}

class Data {
    private CBE_GetNewSessionResponse CBE_GetNewSessionResponse;

    public CBE_GetNewSessionResponse getResponse() {
        return CBE_GetNewSessionResponse;
    }

    public void setResponse(CBE_GetNewSessionResponse response) {
        this.CBE_GetNewSessionResponse = response;
    }

    class CBE_GetNewSessionResponse{

        private String  CBE_GetNewSessionResult;

        public String getCBE_GetNewSessionResult() {
            return CBE_GetNewSessionResult;
        }

        public void setCBE_GetNewSessionResult(String cBE_GetNewSessionResult) {
            CBE_GetNewSessionResult = cBE_GetNewSessionResult;
        }
    }
}