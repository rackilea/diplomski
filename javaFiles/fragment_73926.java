+ "movie=" + watermark + " [watermark];"
                    + "[1]scale=iw/2.5:ih/2.5,split[vid2a][vid2b];"
                    + "[vid2a]trim=end=80.5,fifo[vid2a-ol];"
                    + "[vid2b]trim=start=80.5,setpts=PTS+3.5/TB,fifo[vid2b-ol];"
                    + "[0][vid2a-ol]overlay=10:10:enable=\'between(t,0,84)\',fifo[outv1];"
                    + "[outv1][vid2b-ol]overlay=10:10:enable=\'between(t,84,101)\',fifo[outv12];",
                    + "[outv12][watermark]overlay=main_w-overlay_w-10:main_h-overlay_h-10 [outv0]"