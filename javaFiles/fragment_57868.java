RunWith(PowerMockRunner.class)
@PrepareForTest( Bar.class )
public class BarTest {


@Test
public void test(){
   Foo mockedFoo = createMock(Foo.class);
   //set up mockedFoo here
   ...

   //This will make a call  to new Foo() inside Bar.class
   //return your mock instead of a real new one
   expectNew(Foo.class).andReturn(mockedFoo);

   ...
   replay(mockedFoo, File.class);

   Bar bar = new Bar();
   String response = bar.bar();

   assertEqual(response, <mocked response>);

   verify(mockedFoo, File.class);


}

}