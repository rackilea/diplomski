Runtime.getRuntime().exec(
  new String[] {
    "ffmpeg",
    "-i",
    "concat:/home/temp 10.avi|/home/p2.avi|/home/temp15.avi",
    "-c",
    "copy",
    "-y",
    "/home/output.avi"
  }
)