User user = new User();
        user.setName('test');
        user.setPassword('password');
        // setting media type as xml, and telling convert my user java obj to xml
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<User> entity = new   HttpEntity<User>   (user , headers);

        ResponseEntity<validUser> responseEntity = rest.exchange(URL, HttpMethod.POST, entity, validUser.class);
    // let us assume that service response for valid user <validCode>1<validCode>
    //then validuserreponse obj will have code as 1, let us say valid user.
    ValidUser validUserResponse = responseEntity.getBody();