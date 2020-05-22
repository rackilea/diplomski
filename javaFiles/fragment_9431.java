if (!aes.matches(request.getPassword(), dbUser.getPassword())) {
    return ResponseEntity.status(403).build();
}
else {
    return logUserIn(dbUser);
}