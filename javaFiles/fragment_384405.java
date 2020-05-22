Runtime.getRuntime().exec(
  new String[] {
    "ffmpeg",
    "-i",
    "sample.mp4",
    "-i",
    "ad.mp4",
    "-filter_complex",
    "[0:v]trim=0:15,setpts=PTS-STARTPTS[v0]; [1:v]trim=0:5,setpts=PTS-STARTPTS[v1]; [0:v]trim=20:30,setpts=PTS-STARTPTS[v2]; [v0][v1][v2]concat=n=3:v=1:a=0[out]",
    "-map",
    "[out]",
    "output.mp4"
  }
)