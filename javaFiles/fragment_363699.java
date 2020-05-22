//create a new audio and video source, this is the stream that will be sent to the remote
VideoSource videoSource = factory.createVideoSource(VideoCapturer.create("Camera 1, Facing front, Orientation 270"), new MediaConstraints());
AudioSource audioSource = factory.createAudioSource(new MediaConstraints());

//create a new audio and video track
VideoTrack videoTrack = factory.createVideoTrack("ARDAMSv0", videoSource);
AudioTrack audioTrack = factory.createAudioTrack("ARDAMSa0", audioSource);

//create a new media stream, this holds all local streams and their tracks
MediaStream lms = factory.createLocalMediaStream("ARDAMS");

//create a new video renderer and add it to the video track
VideoRenderer renderer = new VideoRenderer(parent);
videoTrack.addRenderer(renderer);

//add the video track to the stream
lms.addTrack(videoTrack);
//add the audio track to the stream
lms.addTrack(audioTrack);

//add the stream to the connection
peerConnection.addStream(lms);