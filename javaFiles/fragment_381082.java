try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resetBoard();
        firstComputerMove = true;
        computerMove();