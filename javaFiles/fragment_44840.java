public void run() {
    callTimeSeconds++;
    do {
        if (handleInjectDMTFTone())
            break;
        if (handleInjectEndCall())
            break;
    } while(false);

    callTime.schedule(callTimeTask, 0,1000);
}

boolean handleInjectDMTFTone() {
    if ((callTimeSeconds != Options.getSoftLimit().intValue()) ||
        (Phone.getActiveCall().getStatus() != PhoneCall.STATUS_CONNECTED))
        return false;

    injectDTMFTone(Phone.getActiveCall());
    return true;
}

boolean handleInjectEndCall() {

    if ((callTimeSeconds < Options.getHardLimit().intValue()) ||
        (Phone.getActiveCall().getStatus() != PhoneCall.STATUS_CONNECTED))
        return false;

    injectEndCall();
    return true;
}