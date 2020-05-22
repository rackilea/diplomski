Snmp snmp = new Snmp(transport);
CommandResponder trapPrinter = new CommandResponder() {
    public synchronized void processPdu(CommandResponderEvent e) {
        PDU command = e.getPDU();
    }
};