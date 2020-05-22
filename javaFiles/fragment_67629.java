Intent intent = new Intent(this, AnotherActivity.class);
    ArrayList<String> allTexts = new ArrayList<>();
    for (EditText e : allEds) {
        allTexts.add(e.getText().toString())
    }
    intent.putExtra("Text", (Serializable) allTexts);