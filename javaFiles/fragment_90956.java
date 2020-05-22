public static class Builder {

        private String username;
        private Boolean enabled;

        public Builder setUsername(String username) {
            this.username = username;
            return this; 
        }

        public Builder setEnabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public UserResponseDTO build(){
            return new UserResponseDTO(username, enabled);
        }
    }