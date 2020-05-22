SimpleDateFormat dayFormatter=new SimpleDateFormat("dd/MM/yyyy");
Map<String,List<JsonNode>> result = events.stream()
    .collect(Collectors.groupingBy(event -> dayFormatter.format(event.getDate()),
        Collectors.mapping(event -> {
            ObjectNode jsonMatch = jsonNodeFactory.objectNode();
            jsonMatch.put("name", event.getName());
            return jsonMatch;
        }, Collectors.toList())));