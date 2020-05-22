class User extends Runnable {
    int userId;
    Controller controller;
    Queue<Message> msgQueue;

    void nextMove(int whoMoved, int whatMove){
        msgQueue.offer(new NextMove(whoMoved, whatMove));
    }

    void gameOver(){
        msgQueue.offer(new GameOver());
    }

    run(){
        while(true){
            Message msg = msgQueue.poll();
            if(msg != null){
                // deal with it
                // Maybe send message to controller
                controller.nextMove(new NextMove(userId, 4));
            } else {
                // Do something else, like talking to user
                // sleep to avoid hogging CPU
                Thread.sleep(10);
            }
        }
    }
}