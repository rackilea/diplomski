try (AssetManager am = context.getAssets();
     InputStream is = am.open(vaz.getDatei() + ".pdf");
     OutputStream targetOutputStream = new FileOutputStream(file)) {

     /*
     *[SOME CODE FOR GENERATION AND SAVING]
     */

     Uri path = Uri.fromFile(file);

     Intent viewintent = new Intent(Intent.ACTION_VIEW);
     viewintent.setDataAndType(path, "application/pdf");
     getActivity().startActivity(viewintent);

} catch (InstantiationException | IllegalAccessException e) {
     e.printStackTrace();
}