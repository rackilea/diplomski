@Test
public void thatMachineIdentifierIsCreatedWithMachineAndType() {
    final String machineString = "machine";
    final MachineIdentifierType machineIdType = new MachineIdentifierType();

    final Machine machine = new Machine();
    machine.setMachine( machineString );
    machine.setMachineIdentifierType( machineIdType );

    final Identifier identifier = XYZ.getMachineIdentifierFor( machine );
    assertThat( identifier.getMachine(), is(machineString));
    assertThat( identifier.getMachineIdentifierType(), is( machineIdType ));
}