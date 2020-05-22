@Mock
Timer mockedTimer;

@Test
void constructor(){
   long expectedDelay = ...;
   ClassUnderTest objectUnderTest = new ClassUnderTest(..., mockedTimer);
   Mockito.verify(mockedTimer).schedule(Mockito.any(),  expectedDelay);
}