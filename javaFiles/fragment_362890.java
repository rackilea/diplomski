final File             file;
    final FileChannel      channel;
    final MappedByteBuffer buffer;

    file    = new File(fileName);
    fin     = new FileInputStream(file);
    channel = fin.getChannel();
    buffer  = channel.map(MapMode.READ_ONLY, 0, file.length());