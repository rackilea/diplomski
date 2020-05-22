if(acessToken == null || acessToken.equals("")){
    login();
}else{
   mFacebook.setAccessToken(acessToken); 
   Log.i("teste","Session valid com token salva ? " + mFacebook.isSessionValid());
   sendVideo();
}