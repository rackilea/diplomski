FFprobe ffprobe = new FFprobe("/path/to/ffprobe");
FFmpegProbeResult probeResult = ffprobe.probe("input.mp4");

FFmpegFormat format = probeResult.getFormat();
System.out.format("%nFile: '%s' ; Format: '%s' ; Duration: %.3fs", 
    format.filename, 
    format.format_long_name,
    format.duration
);

FFmpegStream stream = probeResult.getStreams().get(0);
System.out.format("%nCodec: '%s' ; Width: %dpx ; Height: %dpx",
    stream.codec_long_name,
    stream.width,
    stream.height
);