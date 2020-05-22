public void actionPerformed(ActionEvent e) {       
        Object source = e.getSource();
        if (source instanceof MySource) {
           ((MySource)source).executeOnEvent(e, this);
        }
         ....