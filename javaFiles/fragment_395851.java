@GetMapping("/")
        public User getUser() throws JsonProcessingException{
            User user=userSer.getUser(100); 
            System.out.println(user.toString());    
            ObjectMapper mapper=new ObjectMapper();
            System.out.println("Object mapper "+mapper.writeValueAsString(user));

            return user;
        }