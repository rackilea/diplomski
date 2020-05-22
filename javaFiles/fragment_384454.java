// if 1 and 2 are checked, but 3 and 4 aren't
if (q1.isChecked() && q2.isChecked() && !q3.isChecked() && !q4.isChecked()) {
    new AlertDialog.Builder(this).setMessage(R.string.positive).show();         
}

// otherwise, if 3 and 4 are checked, but 1 and 2 aren't
else if (q3.isChecked() && q4.isChecked() && !q1.isChecked() && !q2.isChecked()){
    new AlertDialog.Builder(this).setMessage(R.string.negative).show();         
}