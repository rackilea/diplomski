protected PDU getPDU() 
{
    // create the PDU
    PDU pdu = new ScopedPDU();
    pdu.add(new VariableBinding(SnmpConstants.system));
    pdu.setType(PDU.GETBULK);
    pdu.setMaxRepetitions(10);//or any number you wish
    return pdu;
}