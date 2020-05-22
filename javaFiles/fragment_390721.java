package org.sample;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import android.accounts.Account;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

    private class Uploader extends AsyncTask<Void, String, Integer>
    {
        private List<File> files;
        private boolean canceled;
        private int uploaded;

        public Uploader(Account a, List<File> files)
        {
            this.account = a;
            this.files = files;
        }

        @Override
        protected void onPreExecute()
        {
            uploadSeekBar.setMax(files.size());
            uploadSeekBar.setProgress(0);
            uploadSeekBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Integer result)
        {
            uploadSeekBar.setVisibility(View.INVISIBLE);
            Toast.makeText(Upload.this, result + " files uploaded",
                    Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onCancelled()
        {
            // XXX need a way to actually cancel the last upload
            Toast.makeText(Upload.this, "canceling upload", Toast.LENGTH_LONG)
                    .show();
            this.canceled = true;
            uploadSeekBar.setVisibility(View.INVISIBLE);

        }

        @Override
        protected Integer doInBackground(Void... voids)
        {
            uploaded = 0;
            try
            {
                Iterator<File> it = this.files.iterator();
                while (!canceled && it.hasNext())
                {
                    File file = it.next();
                    it.remove();

                    String msg = "";

                    try
                    {
                        if (debugMode)
                        {
                                                //Put your uploading code here.
                            msg = ("fake uploading " + file);
                            Thread.sleep(3000);
                        } else
                        {
                            msg = ("uploading: " + file);
                            controller.uploadFile(file, this.account);
                        }

                        uploaded++;
                        publishProgress(msg);

                    } catch (IOException e)
                    {
                        controller.te("error uploading file: " + file);
                        controller.te("error uploading file: " + e);
                    } catch (InterruptedException e)
                    {
                    }
                }
            } catch (Exception e)
            {
                publishProgress("error uploading: " + e);
            }

            return uploaded;
        }

        @Override
        protected void onProgressUpdate(String... strings)
        {
            uploadSeekBar.setProgress(uploaded);
            updateUploadMessage(files.size());
            Toast.makeText(Upload.this, strings[0], Toast.LENGTH_LONG).show();
        }
    }