private void getlast6BidData() {
        thread = new Thread() {
            @Override
            public void run() {
                getUpdateBidsList(Constants.detailAuctionGmodel.getRes().getDetail().getCalculate_end());
                try {
                    sleep(last6RunStartTimer);
                    getlast6BidData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

       if (!thread.isAlive()){
          thread.start();
       }
    }