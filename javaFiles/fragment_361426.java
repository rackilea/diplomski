pictureScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override 
            protected void configureScrollBarColors(){
                this.thumbColor = Color.BLUE;
            }
        });
        pictureScrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override 
            protected void configureScrollBarColors(){
                this.thumbColor = Color.BLUE;
            }
        });