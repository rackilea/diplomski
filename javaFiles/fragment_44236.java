public class TestCases(){

@InjectMocks
Test obj=new Test();

@Test
public void list(){
MockitoAnnotations.initMocks(this);
obj.list.add("something");}
}