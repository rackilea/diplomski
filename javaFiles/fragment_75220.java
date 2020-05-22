public Service login(String username, String password) {
        this.username = username;
        this.password = password;

        Args args = new Args();
        args.put("username", username);
        args.put("password", password);
        args.put("cookie", "1");
        ResponseMessage response = post("/services/auth/login", args);
        String sessionKey = Xml.parse(response.getContent())
            .getElementsByTagName("sessionKey")
            .item(0)
            .getTextContent();
        this.token = "Splunk " + sessionKey;
        this.version = this.getInfo().getVersion();
        if (versionCompare("4.3") >= 0)
            this.passwordEndPoint = "storage/passwords";

        return this;
    }