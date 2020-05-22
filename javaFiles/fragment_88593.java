public void showToastDown(Context context, String message) {
    LayoutInflater inflater = ((Activity)context).getLayoutInflater();
    View v = inflater.inflate(R.layout.toast_down, (ViewGroup) ((Activity)context).findViewById(R.id.toast_down_root));

    TextView tvToastDown = v.findViewById(R.id.tvToastDown);
    tvToastDown.setText(message);
    Toast toast = new Toast(context);
    toast.setGravity(Gravity.BOTTOM|Gravity.FILL_HORIZONTAL, 0,0);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.setView(v);
    toast.show();
}