try {
    JSONObject json = response.get();
    Toast.makeText(MainActivity.this, json.toString(), Toast.LENGTH_SHORT).show();
} catch (InterruptedException e) {
    Toast.makeText(MainActivity.this, "Interrupted.", Toast.LENGTH_SHORT).show();
} catch (Exception e) {
    e.printStackTrace();
}