private void getUsers() {

     final String uri = "https://api.myrestservice.com/users";
     RestTemplate restTemplate = new RestTemplate();
     Users result = restTemplate.getForObject(uri, Users.class);      
     System.out.println(result); 
}