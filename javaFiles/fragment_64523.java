private ImageIcon getImage(String path)
{
    URL url = getClass().getResource(path);
    System.out.println(url);
    if (url != null)
        return (new ImageIcon(url));
    return null;
}