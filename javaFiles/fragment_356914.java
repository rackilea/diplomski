data1.stream().forEach(data1 -> { 
        IntStream.range(0, data2.size()).forEach(value -> {
            if (data1.getId().equals(data2.get(value).getID())) {
                data1.setHome(data2.get(value).getHome());
            }
        });
 });