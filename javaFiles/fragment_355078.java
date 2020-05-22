@Test
public void myTest(){
   // ...
   Mockito.when(myClass.myMethod())
          .thenThrow( myException1, 
                      myException1, 
                      myException1, 
                      myException1, 
                      myException1,
                      myException2);
   // ...
}