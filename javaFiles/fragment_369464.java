rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.radioButton1) {
            Toast.makeText(getActivity(), "True", Toast.LENGTH_SHORT).show();
            checked[0] = true;
            answer[0] = true;
        } else {
            checked[0] = true;
            answer[0] = false;
        }
        // update isAnswered[0] to true. as this gets invoked when you choose any radio button.
        isAnswered[0] = true;
    }
});