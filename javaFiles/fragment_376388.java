String credtials = "github.credentials";
GitHub gitHub = GitHubBuilder.fromPropertyFile(credtials)
        .withRateLimitHandler(RateLimitHandler.FAIL)
        .build();
GHRepository repository = gitHub.getRepository("shaunlebron/api-docs");
for (GHRelease release : repository.listReleases()) {
    System.out.println(release.getName());
    for (GHAsset a : release.getAssets()) {
        System.out.println("  -> " + a.getName());
    }
}