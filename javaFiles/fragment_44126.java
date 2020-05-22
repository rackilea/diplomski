listOfListValues.stream()
        .flatMap(list -> {
            if (list.size() > 3) // in this case we use only some of the entries
                return Stream.concat(list.subList(0, 2).stream(), Stream.of("..."));
            else
                return list.stream();
        })
        .collect(Collectors.toList());