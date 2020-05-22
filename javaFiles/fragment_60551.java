@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
    if (result!=null){
        if(result.getContents()==null){
            Toast.makeText(this, "Erreur de Scan", Toast.LENGTH_LONG).show();
        }
        else{
           txtoperatrice.setText(result.getContents());
        }
    }
    else{
        super.onActivityResult(requestCode, resultCode, data);
    }
}