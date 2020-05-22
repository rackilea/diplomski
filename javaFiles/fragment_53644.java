public class One {

    ArrayList<MyImage> images = new ArrayList<MyImage>();

    public One() {
        // perform only initialization here
    }

    // call this method to create the dialog that allows the user to select images
    public void showDialog() {
        DisplayImages displayOne = new DisplayImages(images);

        // pass a reference to this object so DisplayImages can call it back
        displayOne.run(this);
    }

    // this will be called by the action listener of DisplayImages when Done is clicked
    public void processSelectedImages(List<MyImage> selectedImages) {
        images.clear();
        images = selectedImages;

        // do stuff here with images arrylist
    }
}


public class DisplayImages {
    ...
    public void run(final One callback){  // Note that now a reference to the caller is passed
         // creates jpanel and displays images along with a done button

         // user presses done button
         done.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
                 selectedImages = getSelectedImages();

                 // here is how we can send a signal to notify the caller
                 callback.processSelectedImages(selectedImages); 
             }
         });
    }
    ...
}