List<Integer> integers = new ArrayList<>();
integers.add(23);
integers.add(24);

restTemplate.exchange("url", 
    HttpMethod.POST, new HttpEntity<>(integers), new ParameterizedTypeReference<List<Integer>>() {
});