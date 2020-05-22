public final class JsonTest {
    public static void main(final String[] args) {
        final String json = "\"PSY - GANGNAM STYLE (\\uac15\\ub0a8\\uc2a4\\ud0c0\\uc77c) M\\/V\"";
        System.out.println("JSON: " + json);

        try {
            // ObjectMapper is from Jackson 2.1 databind library.
            final ObjectMapper mapper = new ObjectMapper();
            final String decoded = mapper.readValue(json, String.class);
            System.out.println("Decoded: " + decoded);
        }
        catch (final IOException e) {
            e.printStackTrace();
        }
    }
}