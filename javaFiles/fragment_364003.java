import java.awt.Component;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
import procedure.findings4.View.TextAreaDestination;

public class Control {
   public static final boolean DEBUG = false;

   public static final String CENTRICITY_WINDOW_NAME = "Centricity EMR";
   private DriverModel driverModel = null;
   private View view;
   private Map<View.GuiButtonText, Runnable> runnableMap = new HashMap<View.GuiButtonText, Runnable>();

   public Control() {
      runnableMap.put(View.GuiButtonText.GET_ONE_PROC, new GetOneProcRunnable());
      runnableMap.put(View.GuiButtonText.GET_TWO_PROCs,
            new GetTwoProcsRunnable());
      runnableMap.put(View.GuiButtonText.INTO_FLOW, new IntoFlowRunnable());
      runnableMap.put(View.GuiButtonText.CLEAR_ALL, new ClearAllRunnable());
      runnableMap.put(View.GuiButtonText.SIGN_NEXT, new SignNextRunnable());
      runnableMap.put(View.GuiButtonText.EXIT, new ExitRunnable());
   }

   public void setView(View view) {
      this.view = view;
      view.addPropertyChangeListener(new ViewChangeListener());
   }

   //....

   private class ViewChangeListener implements PropertyChangeListener {
      @Override
      public void propertyChange(PropertyChangeEvent pcEvt) {
         if (pcEvt.getPropertyName().equals(View.BUTTON_PRESSED)) {
            Runnable run = runnableMap.get(pcEvt.getNewValue());
            if (run != null) {
               run.run();
            }
         }
      }
   }

   //....