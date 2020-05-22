@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (data != null && data.getExtras().containsKey("Days")) {
        int i = data.getExtras().getIntExtra("Days", days);
        TextView tvD = (TextView) findViewById(R.id.MA_TvDays);
        if (tvD != null) tvD.setText("" + i);
    }
}