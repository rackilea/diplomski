Irc irc = spy(Irc.class, withSettings().defaultAnswer(CALLS_REAL_METHODS));

// Business method
irc.received(":jtv MODE #channel +o user");

// Asserts
verify(irc).onModeChange("#channel", "user", true, "o", "jtv");