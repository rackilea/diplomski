byte[] payload = "Hello world!";

int length = payload.getBytes(Charsets.UTF_8);

Packet packet = new Packet(1, length, payload);

client.send(packet);