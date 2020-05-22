try {
   throw new CustomException();
} catch(CustomException e) {
  e.printStackTrace();
  return new ResponseEntity<String>(e.getErrorDescription(),e.getStatusCode());
}