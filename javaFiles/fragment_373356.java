enable = (Button) rootView.findViewById(R.id.enable);
enable.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      editor.putInt("yourTheme", 2);
      editor.commit();
        listener.themechanged(2);
        enable.setVisibility(View.GONE);
        disable.setVisibility(View.VISIBLE);

    }
});
disable = (Button) rootView.findViewById(R.id.disable);
disable.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        editor.putInt("yourTheme", 1);
        editor.commit();
        listener.themechanged(1);
        disable.setVisibility(View.GONE);
        enable.setVisibility(View.VISIBLE);
    }
});