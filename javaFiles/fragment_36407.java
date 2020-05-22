ExecutorService exec = Executors.newFixedThreadPool(numberOfCrawlers);
while(true){
    URL url = frontier.get();
    if(url == null){
        if(!coordinator.shouldTryAgain()){
            //all threads are waiting. No possibility of new jobs.
            return;
        }else{
            //Possible that there are other jobs. Try again
            continue;
        }
    }
    exec.execute(new URLCrawler(this, url));
}//while(true)