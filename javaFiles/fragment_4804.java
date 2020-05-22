ResponseEntity<String> response= new ResponseEntity<String> ("\"<200 OK OK,{\\\"status\\\":200,\\\"success\\\":true,\\\"info\\\":{\\\"mid\\\":\\\"id\\\":\\\"95706\\\"}}},[]>\"", HttpStatus.OK);


String responseStr = response.getBody();
int begin = responseStr.indexOf("{");
int end = responseStr.lastIndexOf("}") + 1;

responseStr = responseStr.substring(begin, end);
System.out.println(responseStr);