private void saveImagesToDisk() {
      textArea.append("\nPreparing to save photos to photos directory\n\n");

      final SwingWorker<Void, String> imageWorker = new SwingWorker<Void, String>() {
         @Override
         protected Void doInBackground() throws Exception {

            for (MediaFeedData mfd : imagesMetaDataList) {
               final String imageURL = mfd.getImages().getLowResolution().getImageUrl();
               final String filename = mfd.getId();
               System.out.println(filename);
               String textToPublish = "";
               if (SaveImageFromUrl.saveImage(imageURL, filename, textArea)) {
                  textToPublish = filename + " written to photos directory\n";
               } else {
                  textToPublish = filename + " not saved!\n";
               }

               // publish String so it can be used in the process method
               publish(textToPublish);
            }
            return null;
         }

         @Override
         protected void process(List<String> chunks) {
            // Strings sent to the EDT by the publish method
            // This called on the Swing event thread.
            for (String chunk : chunks) {
               textArea.append(chunk);
            }
         }
      };

      imageWorker.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
               try {
                  // need to call this on the event thread
                  // to catch any exceptions that have occurred int he Swing Worker
                  imageWorker.get();
               } catch (InterruptedException e) {
                  e.printStackTrace();
               } catch (ExecutionException e) {
                  // TODO catch exceptions buried in this guy
                  e.printStackTrace();
               }
            }
         }
      });

      // run our SwingWorker
      imageWorker.execute();
   }