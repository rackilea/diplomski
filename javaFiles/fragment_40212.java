Printer printer = new Printer(6);
    PingPongThread pingThread = new PingPongThread(printer, "Ping");
    synchronized (printer) {
        printer.wait();
    }
    PingPongThread pongThread = new PingPongThread(printer, "Pong");