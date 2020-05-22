@Bean
ItemProcessor<UserDTO, UserDTO> userProcessor() {
    return item -> {
        try {
            item.setGender(UserDTO.Gender.getGender(item.getSex()));
        } catch (Exception ex) {
            log.error("Error trying to process user '{}'", item.getId());
        }
        return item;
    };
}