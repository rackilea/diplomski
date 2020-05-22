/**
 * Get languages used in a repository
 *
 * @throws IOException
 */
@Test
public void getLanguages() throws IOException {
    RepositoryService service = new RepositoryService(client);
    Map<String, Long> languages = service.getLanguages(new RepositoryId(
            "defunkt", "resque"));
    assertNotNull(languages);
    assertFalse(languages.isEmpty());
    for (Entry<String, Long> language : languages.entrySet()) {
        assertNotNull(language.getKey());
        assertFalse(language.getKey().length() == 0);
        assertTrue(language.getValue() > 0);
    }
}