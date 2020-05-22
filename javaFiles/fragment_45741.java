MediaFormat mMediaFormat = new MediaFormat();
mMediaFormat = MediaFormat.createAudioFormat(mMime,
    mMediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE),
    mMediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT));

mMediaCodec.configure(mMediaFormat, null, null, 0);
mMediaCodec.start();