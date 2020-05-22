list.post (new Runnable()
      {
        @Override public void run() 
        {
          String dataFromServer = networkManager.receiveData();
          list.add(dataFromServer);
          adapter.notifyDataSetChanged();
        }
      });