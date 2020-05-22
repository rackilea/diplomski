public class Deserialize {

    public static void main(String[] args) throws Exception {
        String serialized = 
            "rO0ABXNyAA9TaWduZWRUaW1lc3RhbXCGTHiJ+JenzgIAA0wAA29ianQAEExqYXZhL2xhbmcvTG9uZztbAAlzaWduYXR1cmV0AAJbQkwAEnNpZ25hdHVyZUFzQVN0cmluZ3QAEkxqYXZhL2xhbmcvU3RyaW5nO3hwc3IADmphdmEubGFuZy" +
            "5Mb25nO4vkkMyPI98CAAFKAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAAAAAABkdXIAAltCrPMX+AYIVOACAAB4cAAAAAGAdAANSGVsbG8sIHdvcmxkIQ==";
        SignedTimestamp o = (SignedTimestamp) Serializables.FromString(serialized);

        System.out.println(o.getObj());
        System.out.println(o.getSignature());
        System.out.println(o.getSignatureAsAString());
    }

}