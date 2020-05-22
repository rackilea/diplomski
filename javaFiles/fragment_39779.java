InputStream instr = null;
try {
  instr = Utils.class.getResourceAsStream("/car.jpg");
  TextureIO.newTexture(instr, false, "jpg");
} finally {
  instr.close();
}