public class MyFocusPanel extends DockLayoutPanel
{
      private FocusPanel f1 = new FocusPanel();
      private FocusPanel f2 = new FocusPanel();
      private FocusPanel f3= new FocusPanel();
      private FocusPanel f4 = new FocusPanel();

      public MyFocusPanel ()
      {
           super(Unit.PX);
           f1.addClickHandler ( new ClickHandler() 
           {
               public void OnClick()
               {
                     onFocusPanelClick();
               }
           });
           f2.addClickHandler ( new ClickHandler() 
           {
               public void OnClick()
               {
                     onFocusPanelClick();
               }
           });
           f3.addClickHandler ( new ClickHandler() 
           {
               public void OnClick()
               {
                     onFocusPanelClick();
               }
           });
           f4.addClickHandler ( new ClickHandler() 
           {
               public void OnClick()
               {
                     onFocusPanelClick();
               }
           });

           addNorth( f1, 5.0 );
           addWest( f2, 5.0 );
           addEast( f3, 5.0 );
           addWest( f4, 5.0 );
}