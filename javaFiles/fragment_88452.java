while (running) {
    count++;
try{
        v1.draw(new Canvas(bitmap));//I am getting exception here
        //sleep thread to give some lag
    } catch(ArrayIndexOutOfBoundException e){
        e.printStackTrace();
        //do handling action.. or skip as per ur requirement.
    }
try {
        Thread.sleep(30);
    } catch (InterruptedException e) {
        e.printStackTrace();
        throw new RuntimeException(e.getMessage());
    }

    System.out.println("Bitmap : [ " + count + " ] >>>>>>>> SAVED. ");

}