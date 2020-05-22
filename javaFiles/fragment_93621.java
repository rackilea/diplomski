Predicate<Client> hasSameNameAsOneUser = 
    c -> users.stream().anyMatch(u -> u.getName().equals(c.getName()));

return clients.stream()
              .filter(hasSameNameAsOneUser)
              .collect(Collectors.toList());