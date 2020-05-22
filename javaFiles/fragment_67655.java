@Override
public void onClick(View arg0) {    
    Intent intentSettings = new Intent(X.this,Settings.class);
    showToast("Settings clicked,");
    try{
    startActivity(intentSettings); 
    }
    catch(Exception e){
        showToastL("Exception" + e);
    }
    return;
}
});