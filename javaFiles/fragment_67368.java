Object something;
Object somethingElse;

@BeforeTest
public void beforeTest() {
    new MockUp<MyObject>() {
        @Mock
        public void insert() { }  // override the "actual" DB insert
    };                            // of Row.insert()
}

@Test
public void testCreation() {
    MyObject mock = new MyObject(something);  // object correctly init'd
                                              // by Row.initialize(Object)
    new Expectations(MyObject.class) {{
        new MyObject(something);     result = mock;
        mock.insert(somethingElse);
    }};

    MyObject test = Factory.createObject(something, somethingElse);
}