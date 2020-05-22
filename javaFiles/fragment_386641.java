Map<String,Object> firstAuthor =  authors
                                        .stream()
                                        .filter(author -> {
                                            Object foods = author.get("foods");
                                            if(foods instanceof List) {
                                                List foodsList = (List) foods;
                                                return foodsList.containsAll(collection);
                                            }
                                            return false;
                                        })
                                       .findFirst().orElse(null);