cb118.setOnCheckedChangeListener(new OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        editor.putBoolean(cb118Key, isChecked);
        editor.commit();
    }
});