@Test
public myTest(){
    MyMainModel mainModel =  Mockito.mock(MyMainModel.class);
    List<SomeModel> someModelList = getSomeList();
    Mockito.when(mainModel.getList()).thenReturn(someModelList);
}