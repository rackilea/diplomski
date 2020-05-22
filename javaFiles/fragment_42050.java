import org.junit.jupiter.api.io.TempDir;

@Test
void writesContentToFile(@TempDir Path tempDir) throws IOException {
    // arrange
    Path output = tempDir
            .resolve("output.txt");

    // act
    fileWriter.writeTo(output.toString(), "test");

    // assert
    assertAll(
            () -> assertTrue(Files.exists(output)),
            () -> assertLinesMatch(List.of("test"), Files.readAllLines(output))
    );
}