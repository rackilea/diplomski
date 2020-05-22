@Test
public shoudReturnQueryTimeGivenValidExamSession(){
    Module mod = new Module() ; 
    String input = "some_string";
    Integer result = 1;//Some integer

    // Set the expectations
    Object object = Mock(Object.class) ; // This should be class(in place of object) of type es
    Object object1 = Mock(Object.class) ; // This should be class of what es.get(1) returns. I assume es is a list of somethings and es.get(1) returns an object of your custom class. So In prev line, Object -> ArrayList, this line Object -> YourCustomObject
    when(object.get(1)).thenReturn(object1); 
    when(object1.getid()).thenReturn(input);
    when(object1.getTimeOfExam()).thenReturn(result);

    //Make the call
   Integer actualResult = mod.queryTime(input);

    //Verify
   assertEquals(result, actualResult);
}