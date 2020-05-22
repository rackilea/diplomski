@Override
        public void onResume() {
            super.onResume();
            final File file = new File(Environment.getExternalStorageDirectory() + "/download/app-debug.apk");
            final Button down = (Button) findViewById(R.id.down);
            down.setEnabled(!file.exists());
            final Button install = (Button) findViewById(R.id.install);
            install.setEnabled(file.exists());
        }