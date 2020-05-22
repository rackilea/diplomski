// a bean that keeps track of the colors
public static class ColorTracker extends AbstractBean {

    private List<Color> colors = new ArrayList<>();

    public void addColor(Color color) {
        List<Color> old = getColors();
        colors.add(0, color);
        firePropertyChange("colors", old, getColors());
    }

    public void setColors(List<Color> colors) {
        List<Color> old = getColors();
        this.colors = new ArrayList<>(colors);
        firePropertyChange("colors", old, getColors());
    }

    public List<Color> getColors() {
        return new ArrayList<>(colors);
    }
}

// a custom SwatchChooserPanel which takes and listens to the tracker changes
public class MySwatchChooserPanel ... {

   ColorTracker tracker;

   public void setColorTracker(....) {
       // uninstall old tracker 
       ....
       // install new tracker
       this.tracker = tracker;
       if (tracker != null) 
           tracker.addPropertyChangeListener(.... );
       updateRecentSwatchPanel()
   }

   /** 
    * A method updating the recent colors in the swatchPanel
    * This is called whenever necessary, specifically after building the panel,
    * on changes of the tracker, from the mouseListener
    */
   protected void updateRecentSwatchPanel() {
       if (recentSwatchPanel == null) return;
       recentSwatchPanel.setMostRecentColors(tracker != null ? tracker.getColors() : null);
   }

// the mouseListener which updates the tracker and triggers the doubleClickAction
// if available
class MainSwatchListener extends MouseAdapter implements Serializable {
    @Override
    public void mousePressed(MouseEvent e) {
        if (!isEnabled())
            return;
        if (e.getClickCount() == 2) {
            handleDoubleClick(e);
            return;
        }

        Color color = swatchPanel.getColorForLocation(e.getX(), e.getY());
        setSelectedColor(color);
        if (tracker != null) {
            tracker.addColor(color);
        } else {
            recentSwatchPanel.setMostRecentColor(color);
        }
    }

    /**
     * @param e
     */
    private void handleDoubleClick(MouseEvent e) {
        if (action != null) {
            action.actionPerformed(null);
        }
    }
}


} 

// client code can install the custom panel on a JFileChooser, passing in a tracker
private JColorChooser createChooser(ColorTracker tracker) {
    JColorChooser chooser = new JColorChooser();
    List<AbstractColorChooserPanel> choosers = 
            new ArrayList<>(Arrays.asList(chooser.getChooserPanels()));
    choosers.remove(0);
    MySwatchChooserPanel swatch = new MySwatchChooserPanel();
    swatch.setColorTracker(tracker);
    swatch.setAction(doubleClickAction);
    choosers.add(0, swatch);
    chooser.setChooserPanels(choosers.toArray(new AbstractColorChooserPanel[0]));
    return chooser;
}