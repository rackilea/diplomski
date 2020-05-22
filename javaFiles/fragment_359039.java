public static class Converter extends StdConverter<User, UserDto> {
        @Override
        public UserDto convert(User value) {
            return UserDto.fromUser(value);

        }
    }