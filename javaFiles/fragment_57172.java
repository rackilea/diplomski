public void uninstall(String pack)
{
    Uri packageuri = Uri.parse("package:" + pack);
    Intent intent = new Intent(Intent.ACTION_DELETE, packageuri);
    startActivity(intent);
}