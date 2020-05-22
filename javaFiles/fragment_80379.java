@Override
public void onClick(View view){
    goToNextView();
}

private void goToNextView(){
    if (title_subjects[0] == "Soft Computing") {
        Intent intent = new Intent(ActivityBookDetails.this, pdfviewactivity.class);
        startActivity(intent);
    }
    // else if {}
    // else {}
}