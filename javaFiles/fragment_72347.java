FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if (user != null) {
    // User is signed in
} else {
    // No user is signed in
}