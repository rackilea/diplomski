list.stream()
                .collect(Collectors.toMap(
                        Model::getId,
                        Model::getName,
                        (v1,v2) -> v2
                ));