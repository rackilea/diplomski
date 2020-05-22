@RunWith(PowerMockRunner.class)
@PrepareForTest({ServiceLocator.class})
class ChildTest{

    @Test
    public void doSomeJob(){
        PowerMockito.mockStatic(ServiceLocator.class);
        AddressService addressService = Mockito.mock(AddressService.class);
        // commented as no more required
        // PowerMockito.when(ServiceLocator.getService(AddressService.class)).thenReturn(addressService);

        Child original = new Child();
        Child spiedObj = PowerMockito.spy(original);
        // using Whitebox API
        Whitebox.setInternalState(spiedObj, AddressService.class, addressService);
        spiedObj.doSomeJob();
    }

}