public class Example
{
    public ImageIcon loadImage()
    {
        // Note the '/'
        final String path = "/Resources/character.png"; 

        // Load the image as a resource
        ImageIcon icon = new ImageIcon(this.getClass().getResource(path));

        // Return the result
        return icon;
    }
}

// ...

Example e = new Example();
ImageIcon icon = e.loadImage();