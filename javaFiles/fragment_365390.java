ConnectionConfiguration connConfig = new ConnectionConfiguration("ip", 5222);
            XMPPConnection connection = new XMPPConnection(connConfig);

            connection.connect();
            connection.login("username", "password");
            AccountManager accountManager = connection.getAccountManager();
            accountManager.createAccount("adminCreated1", "123456");
            connection.disconnect();