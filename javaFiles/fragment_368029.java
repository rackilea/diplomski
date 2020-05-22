boolean result = Arrays.asList(1, 2, 3).stream()
            .allMatch(i -> objects
                .stream()
                .map(MyObject::getId)
                .filter(j -> j == i).findAny().isPresent());
    Assert.assertTrue(result);