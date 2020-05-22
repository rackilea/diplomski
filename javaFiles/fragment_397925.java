public void testDBToOption() {      
    assertEquals(EnumOption.NO, EnumOption.DBToOption("N"));
    assertEquals(EnumOption.YES, EnumOption.DBToOption("Y"));
    assertEquals(EnumOption.DEFAULT, EnumOption.DBToOption(""));
    assertEquals(EnumOption.DEFAULT, EnumOption.DBToOption(null));
    assertEquals(EnumOption.DEFAULT, EnumOption.DBToOption("R"));
}