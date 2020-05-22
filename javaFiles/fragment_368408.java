IntByReference returnCode = new IntByReference(0);
boolean success = zGraphics.ZBRGDIDrawText(
    0,
    0,
    "Print this",
    "Arial",
    12,
    1,
    0x0FF0000,
    returnCode
);

if (success) {
    System.out.println("success");
} else {
    System.out.println("ZBRGDIDrawText failed with code " + returnCode.getValue());
}