// ...
JsonNode filesNode = jsonNode.at("/searchResults/file");
if (filesNode.isArray()) {

  for (JsonNode fileNode : filesNode) {
    String repoName = fileNode.at("/repository/$").asText();
    if (repoName.equals(targetRepoName)) {

      for (JsonNode linkNode : fileNode.at("/link")) {
        if ("content".equals(linkNode.get("@rel").asText())) {
          contentURL = linkNode.get("$").asText();
        }
      }
    }
  }
}