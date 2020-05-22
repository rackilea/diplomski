@Test
public void testMain(){
    main = new Main();
    main.setChild(child); // tell it to use the mock
    main.play(); 
    Mockito.verify(child).getNumber();
}