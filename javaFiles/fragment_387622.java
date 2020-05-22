tmpMap.entrySet()
        .stream()
        .map(
                entry -> new Data(
                        entry.getKey(),
                        entry.getValue().entrySet().stream()
                                .max(Map.Entry.comparingByValue()).get().getKey()
                )
        ).collect(toList()); 
//[Data{name='Dummy', value=7.0}, Data{name='Ossas', value=10.0}, Data{name='Uvumvew', value=10.0}]