import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class EventController {
    private EventModel model;
    private EventView  view;
    String tableClick;
    Events events;

    private MouseAdapter mouseListener = new MouseAdapter() {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent event) {
          int rowSelected = view.tableEvent.getSelectedRow();
           //blahblahblah
          view.changeDisplay(events);
        }
    };

    private KeyAdapter keyAdapter = new KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent e) {
            // Perform here whatever is needed
            // You also have access to your enclosing instance EventController.this and its methods
        }
    };

    private ActionListener actionListener = new ActionListener() {@Override
               public void actionPerformed(ActionEvent e){
           Object button = e.getSource();
           if(button==this.view.addEventButton) {
               setEventDetails();          
           }

       }



    /** Constructor */
   public EventController(EventModel myModel, EventView myView){
       model = myModel;
       view = myView;     
    }

   public void setUpListeners() {
       this.view.addEventButton.addActionListener(actionListener); 
       this.view.addEventMenuItem.addActionListener(actionListener);
       this.view.editEventMenuItem.addActionListener(actionListener);
       this.view.tableEvent.addMouseListener(mouseListener);
       // Here you can also add the keyadapter to your views
   }


 }