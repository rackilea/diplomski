Context context = view.getContext(); // or Context context = getContext();
if (context instanceof Activity) {
    Activity activity = (Activity) context;

    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
    activity.startActivity(intent);
}