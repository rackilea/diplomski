//initialize the peerconnection factory
PeerConnectionFactory.initializeAndroidGlobals(MainActivity.context, true, true, true, parent.tex_remote);
factory = new PeerConnectionFactory();

//ice server initialization
ArrayList<PeerConnection.IceServer> iceServers = new ArrayList<>();
iceServers.add(new PeerConnection.IceServer("stun:stun.xxx.xxx:xxx"));
iceServers.add(new PeerConnection.IceServer("turn:turn.xxx.xxx:xxx", "xxx", "xxx"));

//create a new contraints object to configure the connection
MediaConstraints connectionConstraints = new MediaConstraints();
connectionConstraints.mandatory.add(new MediaConstraints.KeyValuePair("offerToReceiveAudio", "true"));
connectionConstraints.mandatory.add(new MediaConstraints.KeyValuePair("offerToReceiveVideo", "true"));
connectionConstraints.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));

//create a new peerconnection object
peerConnection = factory.createPeerConnection(iceServers, connectionConstraints, observer);