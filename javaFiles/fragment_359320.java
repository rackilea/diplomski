ContentInstance cont = new ContentInstance();
 cont.setContent("Sid");
 cont.setStateTag(BigInteger.ONE);
 cont.setContentSize(BigInteger.TEN);

 ObjectMapper om = new ObjectMapper();
 om.setPropertyNamingStrategy(new CustomNamingStrategy());

        try {
            System.out.print("OBJECT MAPPER:---> JSON STRING" + om.writerWithDefaultPrettyPrinter().writeValueAsString(cont));
            jsonContent = om.writerWithDefaultPrettyPrinter().writeValueAsString(cont);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }