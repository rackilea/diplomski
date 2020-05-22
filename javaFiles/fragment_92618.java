try {
        String parameters = "username=" + str1 + "&password=" + str2;
        res = JsonReader
                .excuteGet("http://1.tcesinput.appspot.com/login_s.php?"
                        + parameters);
            }