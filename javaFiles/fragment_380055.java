import java.awt.Desktop;
import java.net.URI;

// ...

if(Desktop.isDesktopSupported())
{
    Desktop.getDesktop().browse(new URI("http://www.example.com"));
}