int input_length = page.getByXPath("//input").size();
    int tries = 5; 
    while (tries > 0 && input_length < 12) { //you can change number of tries and condition according to your need
        tries--;
        synchronized (page) {
            page.wait(2000); //wait
        }
        input_length = page.getByXPath("//input").size(); //input length is example of condtion
    }