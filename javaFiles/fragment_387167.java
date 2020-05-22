String jsonString = null;

        try {

            Jackson jacksonObj = new Jackson(); // populate it as per needs...
            jsonString = objectMapper.writeValueAsString(jacksonObj);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         System.out.println(jsonString); // will return JSON into String formate.