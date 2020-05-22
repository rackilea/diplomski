package com.flasher.config;

        import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;

        public class FlasherPasswordEncoder implements PasswordEncoder {

            @Override
            public String encode(CharSequence rawPassword) {
                return new Md5PasswordEncoder().encodePassword(rawPassword.toString(), AppConstants.MD5_PASSWORD_ENCODER_SALT);

            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return new Md5PasswordEncoder().encodePassword(rawPassword.toString(), AppConstants.MD5_PASSWORD_ENCODER_SALT)
                        .equals(encodedPassword);
            }

        }