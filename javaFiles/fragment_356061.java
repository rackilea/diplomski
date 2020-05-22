@Override
public void onResume(){
        super.onResume();
        if (checkMyServiceRunningOrNot()){
            restoreAcitivty();
        }
    }

public void restoreAcitivty(){
        Intent intent = new Intent(this, RouteActivity.class); 
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent); 
    }