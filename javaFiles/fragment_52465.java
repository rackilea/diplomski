public static ResultDialog newInstance(String message,String title) {
    ResultDialog f = new ResultDialog();
    Bundle args = new Bundle();
    args.putString("message", message);
    args.putString("title", title);
    f.setArguments(args);
    return f;
}