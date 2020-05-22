@Test
public void myTest(){
   // ...
   Mockito.when(myClass.myMethod())
          .thenThrow(myException1)
          .thenThrow(myException1)
          .thenThrow(myException1)
          .thenThrow(myException1)
          .thenThrow(myException1)
          .thenThrow(myException2);
   // ...
}