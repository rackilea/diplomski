public void attemptToLogin(String username, String password){

        Multiscreen multiscreen = new Multiscreen(getApplicationContext());
        multiscreen.loginToIg(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(instagramLoginResult -> {

                    if (instagramLoginResult.getStatus().equals("ok")){

                        dialog.dismiss();
                        MyApp.setInstagramObject(instagramLoginResult);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }

                    else {

                        dialog.dismiss();
                    }
                });
    }