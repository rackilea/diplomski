AssetManager am = context.getAssets();

try (InputStream is = am.open(vaz.getDatei() + ".pdf");
     OutputStream targetOutputStream = new FileOutputStream(file)) {

     ...

} catch (InstantiationException | IllegalAccessException e) {
     e.printStackTrace();
}