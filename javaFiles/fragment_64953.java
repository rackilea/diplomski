ResponseEntry entry = Optional.ofNullable(serviceResponse.getEntryList())
                              .orElseGet(() -> Collections.emptyList())
                              .stream()
                              .filter(e -> "expectedValue".equals(e.getValue()))
                              .findFirst();

if(!entry.isPresent()){ ... } // or entry.ifPresent(e -> ...) depending on the logic you're performing inside the block