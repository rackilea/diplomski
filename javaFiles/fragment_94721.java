@Test
public void thatInteractionWithMachineAndIdentifierIsAsExpected() throws Exception {
    final String machineString = "machine";
    final MachineIdentifierType machineIdType = new MachineIdentifierType();

    final Machine mockedMachined = EasyMock.createMock(Machine.class);
    EasyMock.expect( mockedMachined.getMachine() ).andReturn( machineString );
    EasyMock.expect( mockedMachined.getMachineIdentifierType() ).andReturn( machineIdType );

    final IdentifierImpl mockedIdentifierImpl = EasyMock.createMock(IdentifierImpl.class);
    mockedIdentifierImpl.setMachine(machineString);
    EasyMock.expectLastCall();
    mockedIdentifierImpl.setMachineIdentifierType( machineIdType );
    EasyMock.expectLastCall();

    PowerMock.expectNew(IdentifierImpl.class).andReturn( mockedIdentifierImpl );

    PowerMock.replayAll();

    final IdentifierImpl identifier = (IdentifierImpl) XYZ.getMachineIdentifierFor( mockedMachined );
    assertThat( identifier, is( mockedIdentifierImpl ) );

    PowerMock.verifyAll();
}