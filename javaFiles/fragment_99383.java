@Test
public void getCarsTest(){
    Mockito.when(carsUser.getCars(anyString(), anyString())).thenReturn(getDummyCarsList());

    // ...
}

private Cars[] getDummyCarsList(){
    return new Car{} {new Car(...), new Car(...)};
}