//
// },
// "repository": {
//     "$": "VZMOBILE_13psb6j"
// },
//
String repoName = fileNode.at("/repository/$").asText();
if (repoName.equals(targetRepoName)) {