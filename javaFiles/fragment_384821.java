public static void main(String[] args) throws Exception {
  byte[] key = hexify("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
  byte[] data = hexify("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
  byte[] correct = hexify("773ea91e36800e46854db8ebd09181a72959098b3ef8c122d9635514ced565fe");

  // Create digest
  SecretKey macKey = new SecretKeySpec(key, "HmacSHA256");
  Mac mac = Mac.getInstance("HmacSHA256");
  mac.init(macKey);
  byte[] digest = mac.doFinal(data);
  System.out.println(Arrays.equals(correct, digest));    
}

private static byte[] hexify(String string) {
  return DatatypeConverter.parseHexBinary(string);
}