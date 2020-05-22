connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS `guilds` (\n" +
                        "  `id` text,\n" +
                        "  `prefix` text,\n" +
                        "  `joinmsg` text,\n" +
                        "  `leavemsg` text\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8"

        ).execute();

        connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS `autochans` (\n" +
                        "  `chan` text,\n" +
                        "  `guild` text\n" +
                        ") ENGINE=InnoDB DEFAULT CHARSET=utf8"
        ).execute();