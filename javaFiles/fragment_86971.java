Bundle bundle = new Bundle(); //create the bundle
bundle.putString("USER", user); //attach data to the bundle

inicialpage.setArguments(bundle); //set the bundle on the fragment

//perform fragment transaction
fragmenttransaction.replace(R.id.container, inicialpage);
fragmenttransaction.commit();