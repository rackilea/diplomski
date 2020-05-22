@Test
void testValidFilePath() {
  String filePath = "path.txt";
  String str = sendToECM(filePath);
  Assertions.assertNotEquals(str, ""); // or null, depending on what your StringUtils.EMPTY is doing

@Test
void testInvalidFilePath() {
  String filePath = "invalidPath.txt";
  String str = sendtoECM(filePath);
  Assertions.assertEquals(str, StringUtils.EMPTY);