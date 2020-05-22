User user;
if (SecurityContextHolder.getContext().getAuthentication() != null) {
    user = applicationContext.getBean(User .class);
} else {
    user = createSystemUser();
}
revEntity.setUserId(user.getUserId());