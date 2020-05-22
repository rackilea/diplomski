ResponseEntity<Events[]> responseEntity = restTemplate
            .getForEntity(
                    "http://primesport.sieenasoftware.com/QryApi
                     /GetEvents?
                     username=username&
                     password=password&
                     userid=23",
                     Events[].class);
System.err.println(">>" + responseEntity.getBody().length);