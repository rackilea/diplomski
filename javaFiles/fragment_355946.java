Class<?> c = null;
if(StringClassname != null) {
    try {
        c = Class.forName(className[dayOfYear]);
        Intent intent = new Intent(this, c);
        startActivity(intent);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}