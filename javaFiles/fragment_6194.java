try{

    String json = System.getenv("VCAP_SERVICES"); //NullPointerException, SecurityException

    JsonNode jsonNode = (new ObjectMapper()).readTree(json); //IOException

    if(jsonNode.has("mariadbent") && jsonNode.get("mariadbent").isArray()){

        for(JsonNode elem : jsonNode.get("mariadbent")){

            if(elem.has("credentials")){

                JsonNode cred = elem.get("credentials");

                if(cred.has("host")){

                    System.out.println(
                        cred.get("host").asText() //some-url-to-the-database.service
                    );

                }else{ System.out.println("no host"); }

            }else{ System.out.println("no credentials"); }

        }

    }else{ System.out.println("no mariadbent or not array"); }

}catch(Exception e){ e.printStackTrace(); }