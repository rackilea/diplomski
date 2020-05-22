uiHandler.post(new Runnable()
{
    @Override
    public void run()
    {
        FrameLayout.LayoutParams layout = (android.widget.FrameLayout.LayoutParams) imageView.getLayoutParams();
        layout.height = (int) (2*iconsSizeInDP);
        layout.width = (int) (2*iconsSizeInDP);
        imageView.setLayoutParams(layout);
    }
};
uiHandler.postDelayed(new Runnable()
{
    @Override
    public void run()
    {
        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
        // following code block doesnt'affect imageView dimensions
        layout.height = (int) iconsSizeInDP;
        layout.width = (int) iconsSizeInDP;
        imageView.setLayoutParams(layout);
    }
},50);