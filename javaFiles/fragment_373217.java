[...]
// create a tool chain:
// reader -> addStaticImage -> reduceVolume -> writer
mediaReader.addListener(imageMediaTool);
imageMediaTool.addListener(audioVolumeMediaTool);
audioVolumeMediaTool.addListener(mediaWriter);
[...]