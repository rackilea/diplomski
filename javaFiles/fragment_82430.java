import java.net.SocketException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Name;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

@Path("calendar")
public class CalendarRest {

    @GET
    @Path("test")
    @Produces("text/calendar")
    public Response getCalendarTest() {
        try {
            java.util.Calendar javaCalendar = java.util.Calendar.getInstance();
            javaCalendar.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
            javaCalendar.set(java.util.Calendar.DAY_OF_MONTH, 23);

            Calendar calendar = new Calendar();
            calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
            calendar.getProperties().add(Version.VERSION_2_0);
            calendar.getProperties().add(CalScale.GREGORIAN);
            calendar.getProperties().add(new Name("Eventcalendar"));

            // VEVENT
            VEvent christmas = new VEvent(new Date(javaCalendar.getTime()), "Pre Christmas Day");
            christmas.getProperties().add(new Organizer("TestOrganizer"));
            // initialise as an all-day event..
            UidGenerator ug = new UidGenerator("1");
            christmas.getProperties().add(ug.generateUid());

            calendar.getComponents().add(christmas);

            return Response
                    .ok(calendar.toString())
                    .build();
        } catch (SocketException ex) {
            Logger.getLogger(CalendarRest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CalendarRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.serverError().build();
    }
}