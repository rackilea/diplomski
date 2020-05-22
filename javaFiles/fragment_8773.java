@RunWith(PowerMockRunner.class)
@PrepareForTest( MyClass.class )
public class TestMyClass {

@Test
public void foo() throws Exception {
   SecurityInterface mock = createMock(SecurityInterface.class);

    //intercepts call to new SecurityInterface and returns a mock instead
    expectNew(SecurityInterface.class).andReturn(mock);
    ...
    replay(mock, SecurityInterface.class);
    ...
    verify(mock, SecurityInterface.class);
}

}