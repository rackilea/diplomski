public void setDescriptionText(String text){      
    Runnable toEDT = new Runnable() {

        @Override
        public void run() {
            descriptionTA.setText(text);    
        }
    };

    if(SwingUtilities.isEventDispatchThread()) {
        toEDT.run();
    }else {
        SwingUtilities.invokeLater(toEDT);
    }
}