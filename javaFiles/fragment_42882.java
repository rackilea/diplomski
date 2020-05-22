public EmailMonitor() {
    ini();
    pannelloM = new PannelloM(this);
    pannelloM2 = new PannelloM2(this);
    add(pannelloM2);
}