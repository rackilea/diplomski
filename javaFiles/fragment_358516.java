@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int callId = savedInstanceState.getInt(INCOMING_CALL_ID_EXTRA);
    WeemoCall call = Weemo.instance().getCall(callId);
}