if(auth != null){
    if(auth.equals("User")){
       Intent intent=new Intent(MainActivity.this,Wheels.class);
       startActivity(intent);
    }

    if(auth.equals("Admin")){
       Intent intent=new Intent(MainActivity.this,Admin.class);
       startActivity(intent);
    }
}