public static void main(String[] args) {

        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    new SwingWorker<Object, Object>() {
                        @Override
                        protected Object doInBackground() throws Exception {
                            System.out.println("do in background.....");
                            return null;
                        }
                    }.execute();

                }
            });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }