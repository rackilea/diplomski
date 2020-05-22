String resumeName = YourActivityName.class.getCanonicalName();
try {
    Class newClass = Class.forName(resumeName);
    Intent resume = new Intent(this, newClass);
    startActivity(resume);
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}