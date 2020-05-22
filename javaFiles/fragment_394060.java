<snip>
while (peer->socket.receive(packet) == sf::Socket::Done)
        {
            // Interpret packet and react to it
            handleIncomingPacket(packet, *peer, detectedTimeout);
</snip>