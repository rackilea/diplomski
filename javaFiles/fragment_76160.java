if (FirebaseApp.getApps().isEmpty()) {
    String DATABASE_URL = "https://name.firebaseio.com/";
    try {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("token.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials( GoogleCredentials.fromStream(inputStream))
                .setDatabaseUrl(DATABASE_URL)
                .build();
        FirebaseApp.initializeApp(options);
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error loading database");
    }
}
FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
String uid = decodedToken.getUid();

return service.getAll();