IntStream.range(0, data1.size()).forEach(i -> {
        IntStream.range(0, data2.size()).forEach(j -> {
            if (data1.get(i).getId().equals(data2.get(j).getID())) {
                data1.get(i).setHome(data2.get(j).getHome());
            }            
        });
 });