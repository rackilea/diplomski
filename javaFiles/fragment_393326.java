//class name & annotation → @RunWith(Parameterized.class)
private String name, id, platform, version;
private testClass test;

public testClass(String name, String id, String platform, String version){
    //super();
    this.name = name;
    this.id = id;
    this.platform = platform;
    this.version = version;
}

@Test
//whatever test

@Before
public void initialize() {
    test = new testClass(name, id, platform, version);
}

@Parameterized.Parameters( name = "{2}, {0}")
public static String[][] input() {
    return differentClass.input();
}