protected Question doInBackground(Level... params) {
    Question q;
    while((q = doTheStuff(params))==null){
        updateParams(params);
    }
    return q;
}

private Question doTheStuff(Level.. params){
    //your logic here
}

private void updateParams(Level.. params){
    //update params here
}