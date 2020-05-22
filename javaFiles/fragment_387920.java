return list.stream()
    .filter(x -> x.matches("^[a-zA-Z0-9]+$"))
    .mapToInt(x-> {
      try {
        writer.write(x);
        return x.length();
      } catch (IOException e) {
        return 0;
      }
    })
    .sum();