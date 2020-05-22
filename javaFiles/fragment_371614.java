for (String key : b.keySet()) {
    try {
        Log.d("bundle object", b.get(key).toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}