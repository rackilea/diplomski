public abstract Class Message {
    void send(Receiver r) {
        r.receive(this); // Catch-all
    }
}

public Class Packet extends Message {
    void send(Receiver r) {
        r.receive(this); // Overload for packets
    }
}

public Class Letter extends Message {
    void send(Receiver r) {
        r.receive(this); // Overload for letters
    }
}

public Class Receiver {
    // There is an overload for each subclass
    receive(Packet packet) {
    }
    receive(Letter letter) {
    }
    // This is the catch-all implementation
    receive(Message msg) {
    }
}