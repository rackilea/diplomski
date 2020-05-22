try {
            if (!session.getusename().equals("")) {
                System.out.println("it got here...");
                Intent intent = new Intent(getApplication(), ActivityLogin.class);
                startActivity(intent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                finish();
            } else {
                System.out.println("it got here...3");
                Intent intent = new Intent(getApplication(), ActivityRegistration.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        }catch(Exception ex){

        }