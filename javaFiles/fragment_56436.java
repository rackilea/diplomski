@GetMapping("/jpa/users/{username}/goals")
   public List<Goal> getAllGoals(@PathVariable String username, Principal principal) {
     if ( username.equals(principal.getName()) ) {
       userId = getUserIdFromUsername(username);
       return goalJpaRepository.findByUserId(userId); 
     } else {
       throw new SomeExceptionThatWillBeMapped();
     }
   }