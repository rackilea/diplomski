Path path = Paths.get("c:\\path\\to\\file.ext");
try {
    UserPrincipal owner = Files.getOwner(path, LinkOption.NOFOLLOW_LINKS);
    String username = owner.getName();
} catch (IOException e) {
    e.printStackTrace();
}