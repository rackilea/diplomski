@Test
public void thatInteractionWithMachineIsAsExpected() {
    final String machineString = "machine";
    final MachineIdentifierType machineIdType = new MachineIdentifierType();

    final Machine mockedMachined = EasyMock.createMock(Machine.class);
    EasyMock.expect( mockedMachined.getMachine() ).andReturn( machineString );
    EasyMock.expect( mockedMachined.getMachineIdentifierType() ).andReturn( machineIdType );

    EasyMock.replay( mockedMachined );

    final Identifier identifier = XYZ.getMachineIdentifierFor( mockedMachined );
    assertThat( identifier.getMachine(), is(machineString));
    assertThat( identifier.getMachineIdentifierType(), is( machineIdType ));

    EasyMock.verify( mockedMachined );
}