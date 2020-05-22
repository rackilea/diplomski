// Create a list containing up to 100 registration tokens.
// These registration tokens come from the client FCM SDKs.
List<String> registrationTokens = Arrays.asList(
    "YOUR_REGISTRATION_TOKEN_1",
    // ...
    "YOUR_REGISTRATION_TOKEN_n"
);

MulticastMessage message = MulticastMessage.builder()
    .putData("score", "850")
    .putData("time", "2:45")
    .addAllTokens(registrationTokens)
    .build();
BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
// See the BatchResponse reference documentation
// for the contents of response.
System.out.println(response.getSuccessCount() + " messages were sent successfully");