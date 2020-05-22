private String getAuthToken() {
        String name = user;
        String pwd = this.password;
        String authString = name + ":" + pwd;
        byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
        System.out.println(new String(authEncBytes));
        return "Basic " + new String(authEncBytes);
    }