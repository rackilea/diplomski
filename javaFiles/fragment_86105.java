if (request.equalsIgnoreCase("clients")) {
    channels.write("We currently have: " + channels.size() + " clients /n"); // Forgot /n here
} else if (request.toLowerCase().equals("koko"))
    for (Channel c : channels) {
        if (c == e.getChannel())
            c.write("HELLO WORLD /n"); // <- Forgot /n here as well
    }