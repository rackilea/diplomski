@Override
public void onStart(){
    super.onStart();
    mDatabaseReference.child("Online").addValue();
}

@Override
public void onStop(){
    super.onStop();
    mDatabaseReference.child("Online").removeValue();
}