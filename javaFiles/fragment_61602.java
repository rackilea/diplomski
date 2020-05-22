public abstract class FakeApplicationTest {

    protected static FakeApplication app;

    /**
     * Create a new FakeApplication using all our custom config vars that test against diff DB's
     *
     * @return
     */
    public static FakeApplication createFakeApp() {
        // grab the main application.conf file that is used to start up the Play application
        Config config = ConfigFactory.parseFile(new File("conf/application.conf"));

        // resolve all variables within this config file with other variables within itself
        config = ConfigFactory.load(config);

        // create a Configuration object out of this and then turn it into a Map to be modified
        Configuration configuration = new Configuration(config);
        Map<String, Object> fakeApplicationConf = Maps.newHashMap(configuration.asMap());

        // do some crazy stuff here because Play wants us to for config voodoo, see:
        // http://www.stupidjavatricks.com/2013/05/changing-play-2-db-configuration-at-runtime-beware-of-dragons/
        Configuration akka = configuration.getConfig("akka.actor.serialization-bindings");
        addValue(fakeApplicationConf, "akka.actor.serialization-bindings", null);
        addValue(fakeApplicationConf, "akka.actor.serialization-bindings.\"[B\"", akka.getString("\"[\"B"));
        addValue(fakeApplicationConf, "akka.actor.serialization-bindings.\"java.io.Serializable\"", akka.getString("\"java.io.Serializable\""));

        // point at a different test database
        addValue(fakeApplicationConf, "db.default.url", "jdbc:mysql://127.0.0.1/testdb");
        addValue(fakeApplicationConf, "db.default.user", "someuser");
        addValue(fakeApplicationConf, "db.default.password", "hunter2");

        // disable evolutions and just create the DB manually
        addValue(fakeApplicationConf, "evolutionplugin", "disabled");

        return Helpers.fakeApplication(fakeApplicationConf);
    }

    @BeforeClass
    public static void setUp() throws Exception {
        app = createFakeApp();

        // fire up the Fake Application!
        Helpers.start(app);

        // after we start up the application, create a database
        createCleanDb();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Helpers.stop(app);
    }

    ...
}