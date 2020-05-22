@RequestMapping(value = "/api/restCall", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
public Object restCall(@RequestBody Parameters requestBody,@RequestHeader(value = FIREBASETOKEN, required = true) String idToken) throws Exception {

    // idToken comes from the HTTP Header
    FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get();
    final String uid = decodedToken.getUid();

    // process the code here
    // once it is done
    return object;

}