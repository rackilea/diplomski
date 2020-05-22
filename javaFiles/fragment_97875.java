@Override
protected void onPostExecute(String result) {
    super.onPostExecute(result);
    if(result != null){
        SetTextForTextView(textView, result);
    }
}