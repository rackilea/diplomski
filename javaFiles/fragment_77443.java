try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            Object response = restTemplate.exchange("https://api.hearthstonejson.com/v1/19776/enUS/cards.json", HttpMethod.GET,entity,Object.class);

            System.out.println(response);
        } catch (Exception ex) {
           ex.printStackTrace();

        }