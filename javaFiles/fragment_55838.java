Results_Top_Label.addPropertyChangeListener(Property_Change_Listener);
...
          PropertyChangeListener propertyChangeListener=new PropertyChangeListener()
          {
            @Override
            public void propertyChange(PropertyChangeEvent event)
            {
        //    Out("[x] : "+event.getPropertyName());
              if (event.getSource() instanceof JLabel && event.getPropertyName().equals("html")) 
              {
        //      Out(((JLabel)event.getSource()).getName()+" : Height = "+Results_Top_Label.getPreferredSize().height);
                Results_Split_Pane.setDividerLocation(-1);
              }
            }
          };