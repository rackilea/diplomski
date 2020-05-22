private class ColorChanger extends Thread
{
    final ImageView imageView;
    public ColorChanger(ImageView imageView)
    {
        this.imageView = imageView;
    }

    private void changeColor(final int color)
    {
        YourActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                // Set imageView to color here
            }
        });
    }

    @Override
    public void run() {

        try {
            Thread.sleep(500);
            changeColor(0xffff0000);
            Thread.sleep(500);
            changeColor(0xff0000ff);
            // Etc.
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}