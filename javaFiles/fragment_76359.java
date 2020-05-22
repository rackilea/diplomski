try {
    userService.add(new User(username, password));
} catch (DataIntegrityViolationException e) {
    return "redirect:/register/NOT-OK";
}
return "redirect:/register/OK";