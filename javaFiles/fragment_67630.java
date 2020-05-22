btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View arg0) {
        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
        for (EditText ed : allEds) {
            editor.putString("key" + ed.getTag().toString(), ed.getText().toString());
        }
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        ArrayList<String> allTexts = new ArrayList<>();
        for (EditText e : allEds) {
            allTexts.add(e.getText().toString());
        }
        intent.putExtra("Text", (Serializable) allTexts);
        startActivity(intent);
    }
});