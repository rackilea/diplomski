public void saveSomething(Object toSave) {
     ResTemplate template = new RestTemplate();
     ResponseEntity<CommonResponseObject> response = template.getForEntity(url,CommonResponseObject.class);
     if(response.getStatusCode() == HttpStatus.OK) {
         OKObject ok = response.getBody().getOkObject();
     }
     if(response.getStatusCode() == HttpStatus.FAILED) {
         ErrorObject errorObject = response.getBody().getErrorObject();
     }
}