Set<String> acceptableNames = 
    users.stream()
         .map(User::getName)
         .collect(Collectors.toSet());

return clients.stream()
              .filter(c -> acceptableNames.contains(c.getName()))
              .collect(Collectors.toList());