public static LobHandler getAppropriateLobHandler(Factory factory) {
    LobHandler lobHandler = null;
    switch( factory.getDialect() ) {
        case ORACLE: lobHandler = new OracleLobHandler(); break;
        default: lobHandler = new DefaultLobHandler(); break;
    }
    return lobHandler;
}