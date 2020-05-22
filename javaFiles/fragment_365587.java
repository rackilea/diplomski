final Channel channel = client.newChannel("mychannel");

    channel.addOrderer(client.newOrderer("orderer0", "grpc://localhost:7050"));
    channel.addPeer(client.newPeer("peer0", "grpc://localhost:7051"));

    channel.initialize();