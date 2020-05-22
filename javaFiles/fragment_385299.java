@Test
    public void registerUser() throws Exception{

        super.getLog().info("Register user integration test.");

        HttpHeaders headers = setHeaders(null);
        HttpEntity<UserDto> entity = new HttpEntity<UserDto>(userDto,headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(userBaseUrl+"register_user", HttpMethod.POST, entity, String.class);  

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertNotNull(responseEntity.getBody());    

        ServiceResponse serviceResponse = super.gson.fromJson(responseEntity.getBody(), ServiceResponse.class);     

        Map<String, Object> data = (Map<String, Object>) serviceResponse.getData();

        assertTrue(data.containsKey("accesstoken"));

        assertTrue(data.containsKey("user"));
    }