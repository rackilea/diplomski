new SwingWorker<Void, Void>() {
        private boolean success;

        @Override
        protected Void doInBackground() throws Exception {
            try {
                // Output the `BufferedImage` via `ImageIO`
                if (ImageIO.write(image, "png", new File("Image.png")))
                    success = true;
            } catch (IOException e) {
            }
            return null;
        }

        @Override
        protected void done() {
            if (success) {
                // notify user it succeed
                System.out.println("Success");
            } else {
                // notify user it failed
                System.out.println("Failed");
            }
        }
    }.execute();