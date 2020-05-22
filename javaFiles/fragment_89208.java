InstantiatingGrpcChannelProvider channelProvider =
    InstantiatingGrpcChannelProvider.newBuilder()
        .setKeepAliveTime(Duration.ofSeconds(60L))
        .setKeepAliveTimeout(Duration.ofMinutes(5L))
        .build();

FirestoreOptions firestoreOptions = FirestoreOptions.newBuilder()
    .setChannelProvider(channelProvider).build();

FirebaseOptions options = new FirebaseOptions.Builder()
    .setCredentials(credentials).setFirestoreOptions(firestoreOptions)
    .setConnectTimeout(5000).setReadTimeout(5000).build();
FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);

Firestore firestore = FirestoreClient.getFirestore(firebaseApp);