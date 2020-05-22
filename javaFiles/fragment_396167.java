private final String requestType;
   private final String requestSubType;

    private SearchRequestDTO(SearchRequestDTOBuilder builder){
        this.requestType = builder.requestType ;
        this.requestSubType = requestSubType ;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getRequestSubType() {
        return requestSubType;
    }