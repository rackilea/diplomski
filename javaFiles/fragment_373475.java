new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Toast.makeText(User_Login.this, ""+solution.size(), Toast.LENGTH_SHORT).show();
            Collections.shuffle(solution);
            data();
        }
    },i*3000);