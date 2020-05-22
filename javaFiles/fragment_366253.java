// Fragment: onClickListener
startButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        ((Activity) getActivity()).launchActivity();
    }
}

// FragmentActivity: launchActivity method
public void launchActivity() {
    startActivity(new Intent(Activity.this, StuffActivity.class));
}