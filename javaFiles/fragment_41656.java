import org.gnome.gdk.Event;
import org.gnome.gtk.Gtk;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import org.gnome.notify.Notification;

public class Main {

    public static void main(String[] args) {

        // gtk init
        Gtk.init(args);

        // create main window
        final Window window = new Window();

        // connect delete event to main window
        window.connect(new Window.DeleteEvent() {
            public boolean onDeleteEvent(Widget source, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });

        // create notification
        Notification notification = new Notification("foo", "bar", "baz", window);

        // show widgets
        window.show();
        notification.show();

        // main loop
        Gtk.main();
    }
}