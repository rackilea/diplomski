boolean connection = checkNetworkConnection();
    if(!connection){
        createAlertDialog();
    }
    else{
        whenConnectionActive();
    }