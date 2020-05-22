@Test
public void testname() throws Exception {
    HashReceiver receiver = mock(HashReceiver.class);
    receiver.set("hash");
    verify(receiver).set(argThat(new HashMatcher()));
}

class HashMatcher extends BaseMatcher<String> {
    @Override
    public boolean matches(Object item) {
        String hash = (String) item;
        if (hash.startsWith("/data/inbound/XJSLGG.") && hash.endsWith(".pdf"))
            return true;
        return false;
    }
}

// Mocked
class HashReceiver {
    public void set(String hash) {
    }
}