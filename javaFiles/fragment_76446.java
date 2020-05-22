@Mock private MyClass.ArrayDescriptorFactory mockFactory;
@Mock private ArrayDescriptor mockArrayDescriptor;

...

initMocks( this );
when( mockFactory.makeArrayDescriptor( anyString(), any( Connection.class )))
.thenReturn( mockArrayDescriptor );
MyClass toTest = new MyClass( mockFactory );