Collection<String> foos = Arrays.asList("1", "2", "3", "X", "5", "6", "7", "8", "9", "10");
Collection<String> numbers = foos.stream().filter(s -> {
    try {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}).collect(Collectors.toList());