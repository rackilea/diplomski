private void addQuestionToLayout(final Question question, ViewGroup viewGroup) {
    LinearLayout linearLayout = new LinearLayout(this);
    linearLayout.setOrientation(LinearLayout.VERTICAL);
    TextView textView = new TextView(this);
    textView.setText(question.name);
    linearLayout.addView(textView);
    Spinner spinner = new Spinner(this);
    linearLayout.addView(spinner);
    questionToSpinner.put(question, spinner);
    SpinnerAdapter adapter = new SpinnerAdapter(this, android.R.layout.simple_spinner_item, question);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
    spinner.setAdapter(adapter);
    spinner.setSelection(question.defaultAnswer); // problems???
    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SpinnerAdapter spinnerAdapter = (SpinnerAdapter) parent.getAdapter();
            showToast(spinnerAdapter.question.name + " position=" + position + " id=" + id);
            score.setText(model.formatScoreString(score()));
        }
        public void onNothingSelected(AdapterView<?> parent) {
            SpinnerAdapter spinnerAdapter = (SpinnerAdapter) parent.getAdapter();
            showToast(spinnerAdapter.question.name + " unselected");
        }
    });
    viewGroup.addView(linearLayout);
}
private void addQuestionsToLayout(Model model, ViewGroup viewGroup) {
    for (Question question : model.questions)
        addQuestionToLayout(question, viewGroup);
}