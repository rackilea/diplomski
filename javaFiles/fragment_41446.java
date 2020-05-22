String[] args = new String[]{
    "/usr/bin/mediainfo",
    "--Inform=Video;%Duration%",
    "/home/daniel/upload/videos/4/f/6/e/f/4f6ef2e0d67c4.flv"
};
Runtime.getRuntime().exec(args);