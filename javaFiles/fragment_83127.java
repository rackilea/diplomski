public static void main(String[] args) throws Exception {
    for (Provider provider : Security.getProviders()) {
        for (Map.Entry<Object, Object> entry : provider.entrySet()) {
            if (((String) entry.getValue()).contains("GCM")) {
                System.out.printf("key: [%s]  value: [%s]%n",
                    entry.getKey(),
                    entry.getValue());
            }
        }
    }
}