String str = "{"status":"status","msg":"msg","transaction_details":{"3690":{"mihpayid":"mihpayid","status":"status1"}}}"; 

        try {
            Jackson jacksonObject = objectMapper.readValue(str, Jackson.class);

            System.out.println(" Status -" + jacksonObject.getStatus() +  " : msg - " + jacksonObject.getMsg());

            System.out.println(" Mihpayid -" + jacksonObject.getTransaction_details().getA3690().getMihpayid() +  " : Status - " + jacksonObject.getTransaction_details().getA3690().getStatus());

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }