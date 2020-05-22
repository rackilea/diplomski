@Before
public void executeSomeSql() {
    Connection c;
    try {
        c = dataSource.getConnection();
        c.createStatement()
                .execute("CREATE TABLE \"USER\" (USER_ID NUMBER(10) NOT NULL, CREATOR_USER_FK NUMBER(10) NOT NULL, PRIMARY KEY (USER_ID))");
        c.createStatement()
                .execute("CREATE SEQUENCE SEQ_USER START WITH 1 INCREMENT BY 1");
        c.createStatement()
                .execute("CREATE OR REPLACE TRIGGER \"USER_ID_SEQ_INC\" BEFORE INSERT ON \"USER\" FOR EACH ROW WHEN (new.USER_ID IS NULL) BEGIN SELECT SEQ_USER.nextval INTO :new.USER_ID FROM DUAL; END;");
    } catch (SQLException e) {
        logger.debug(e);
    }
}