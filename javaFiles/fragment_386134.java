@Override
 public void onClick(View view) {
 view.setEnabled(false);
            tvscancontent = tvScanContent.getText().toString();
            tvscanformat = tvScanFormat.getText().toString();
            BackgroundTask backgroundTask = new BackgroundTask();
            backgroundTask.execute(tvscancontent,tvscanformat);
            showShowView2();
           // displaynotification();

        }

    });