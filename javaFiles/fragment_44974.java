new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        OpenGLActivity.this.finish();
    }
}, 3000);