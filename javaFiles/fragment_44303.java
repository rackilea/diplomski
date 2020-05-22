String hashed = BCrypt.hashpw("dog", BCrypt.gensalt(12));
String candidate = "dog";

if (BCrypt.checkpw(candidate, hashed)) {
    Toast.makeText(Loader.this, "equals", Toast.LENGTH_LONG).show();
} else {
    Toast.makeText(Loader.this, "doesn't match?", Toast.LENGTH_LONG).show();
}