public void run(){
    while(true){ // sidenote: I would rearrange the nesting: Wrap the while-loop in the try-catch
        try {
            makeToy();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

private void makeToy() throws InterruptedException{
    main.semaphore.acquire();
    if (main.getToyList() != 0){
        if(rng.nextInt(99) <= 4){ //5% chance to fail
            System.out.println(name + " failed in making a toy!");
        }else{
            main.setToyList(main.getToyList() - 1);
            System.out.println(name + " created a toy! Toys remaining: " + main.getToyList());
        }
    } else {
        wakeSanta();
    }
    main.semaphore.release();
}