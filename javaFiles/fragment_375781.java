Gson gson = new Gson();

var flowers = new ArrayList<Flower>();

Arrays.stream(searchResponse.getHits().getHits()).forEach(hit ->
                    cars.add(gson.fromJson(hit.getSourceAsString(), Car.class)));