File  directory = new File("resource");
Map<String, ImageIcon> iconMap = new HashMap<String, ImageIcon>();

for (File file : directory.listFiles())
{
    // could also use a FileNameFilter
    if(file.getName().toLowerCase().endsWith(".png"))
    {
        iconMap.put(file.getName(), new ImageIcon(file.getPath()));
    }
}