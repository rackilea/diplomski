// Create a directory; all non-existent ancestor directories are
// automatically created
success = (new File("../potentially/long/pathname/without/all/dirs")).mkdirs();
if (!success) {
    // Directory creation failed
}