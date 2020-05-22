public Shape createShapecolor() {
        if(selectedColor == BLUE){
          Color currentColor = Color.blue;
        }
        return currentColor;
      }

      // now create list panel
      public ColorPanel(){
        lineColor = new Choice();
        fillColor = new Choice();

        for (String msg : color_selections) {
          lineColor.add(msg);
          fillColor.add(msg);
        }
        lineColor.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) { 
            //reset line color here when item is selected
              createShapecolor();
            //how to take returned currentColor value and assign it to objects line color?  

              repaint();
          }
        });

        fillColor.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) { 
            //overload fill color here when item is selected
              repaint();
          }
        });

        this.add(lineColor);//this line is driving me nuts.
        //this.add(fillColor);
      }

 }