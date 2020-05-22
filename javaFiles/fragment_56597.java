public String getAsString(OID oid) throws IOException {
    ResponseEvent event = get(new OID[]{oid});
    if(event.getResponse() != null){
        return event.getResponse().get(0).getVariable().toString();
    } else {
        return "no target"
    }
}