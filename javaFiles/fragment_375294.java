Long size = source.length();
        InputStream input = new FileInputStream(source);
        OutputStream output = new FileOutputStream(destination);

            // Transfer bytes from input to output
            byte[] buf = new byte[1024];

            int len;

            long written = 0;

            while ((len = input.read(buf)) > 0) {
                output.write(buf, 0, len);

                written += 1024;

                Long size = source.length();

                InputStream input = new FileInputStream(source);
                OutputStream output = new FileOutputStream(destination);

                // Transfer bytes from input to output
                byte[] buf = new byte[1024];

                int len;

                long written = 0;

                while ((len = input.read(buf)) > 0) {
                    output.write(buf, 0, len);

                    written += 1024;

                    (new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... parms) {
                            mEventDataSource.deleteAll();
                            try {
                                Thread.currentThread().sleep(x * 1000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void result) {
                            // This should be called after x seconds
                            publishProgress((int) (written * 100 / size));
                        }
                    }).execute();

                }

                input.close();
                output.close();