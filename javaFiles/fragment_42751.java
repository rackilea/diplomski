JSch jSch = new JSch();
    Session session = jSch.getSession("new", "sdf.org");
    session.connect();
    Channel channel = session.openChannel("shell");

    Expect expect = new ExpectBuilder()
            .withOutput(channel.getOutputStream())
            .withInputs(channel.getInputStream(), channel.getExtInputStream())
            .withErrorOnTimeout(true)
            .build();
    try {
        expect.expect(contains("[RETURN]"));
        expect.sendLine();
        String ipAddress = expect.expect(regexp("Trying (.*)\\.\\.\\.")).group(1);
        System.out.println("Captured IP: " + ipAddress);
        expect.expect(contains("login:"));
        expect.sendLine("new");
        expect.expect(contains("(Y/N)"));
        expect.send("N");
        expect.expect(regexp(": $"));
        expect.send("\b");
        expect.expect(regexp("\\(y\\/n\\)"));
        expect.sendLine("y");
        expect.expect(contains("Would you like to sign the guestbook?"));
        expect.send("n");
        expect.expect(contains("[RETURN]"));
        expect.sendLine();
    } finally {
        session.close();
        ssh.close();
        expect.close();
    }