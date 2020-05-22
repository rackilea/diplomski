List<User> finalList = new ArrayList<>(users.stream()
        .collect(Collectors.toMap(User::getEmail, Function.identity(), (user1, user2) -> {
            List<Integer> l1 = user1.getLists();
            List<Integer> l2 = user2.getLists();
            List<Integer> merge = IntStream.range(0, l1.size())
                    .mapToObj(i -> (l1.get(i) == 0 && l2.get(i) == 0) ? 0 : 1)
                    .collect(Collectors.toList());
            return new User(user1.getEmail(), merge);
        })).values());