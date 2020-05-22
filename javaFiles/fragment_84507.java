IMediaReader reader = ToolFactory.makeReader(sourceUrl);
 MediaResizer resizer = new MediaResizer(job);
 IMediaWriter currentWriter = ToolFactory.makeWriter(destinationDir, reader);

 reader.addListener(resizer);
 resizer.addListener(currentWriter);