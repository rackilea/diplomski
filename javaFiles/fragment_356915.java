data1.stream().forEach(data1 -> { 
            data2.forEach(data2 -> {
                if (data1.getId().equals(data2.getID())) {
                    data1.setHome(data2.getHome());
                }
            });
});