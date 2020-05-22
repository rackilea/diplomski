public DataFetcher<String> fetchCustomers() {
        return environment -> {
            Person person = environment.getSource();
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(person.getCustomers());
            } catch (JsonProcessingException e) {
                log.error("There was a problem fetching the person!");
                throw new RuntimeException(e);
            }
        };
    }