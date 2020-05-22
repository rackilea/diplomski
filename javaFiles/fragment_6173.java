// Using grizzly as the underlaying server
SelectorThread st = RuntimeDelegate.createEndpoint(new MyApplication(), SelectorThread.class);

st.startEndpoint();

// Wait...
st.stopEndpoint();