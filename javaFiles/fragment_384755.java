StringRequest jsonObjectRequest = new StringRequest(
    Request.Method.GET,
    "https://api.github.com/repos/crashlytics/secureudid/issues",
    new MyListner(),
    new MyErrorListner()
);