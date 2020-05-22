Map<User, String> userMap = new HashMap<User, String>();

for (User user : users) {
    userMap.put(user, calculateSililarity.calculate(sessionUser.getUserId(), user.getUserId()));
}

model.addAttribute("userMap", userMap);