protected void onPreExecute(){
    if(progressBar != null)
        progressBar.setVisibility(ProgressBar.VISIBLE);

    button1.setEnabled(false);
    super.onPreExecute();
}