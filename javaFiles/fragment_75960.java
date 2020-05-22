void resolveResponseCode(List<Dto> dtos,Set<String> responseCode){
   for (DTO dto: dtos){
       if (responses.contains(dto.getCode()){
           dto.setResponseOk(true);
        } else {
           dto.setResponseOK(false);
        }
    }