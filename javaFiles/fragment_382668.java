Server servpub = new Server( servSockpub.accept(), ++pubNumber,
            new MessageReceivedListener()
            {

              @Override
              public void onMessageReceived( String message )
              {
                // call nother local method
                // this method would need to be a static method of Server
                // because it's in the scope of your server class
                sendMessageToSubscribers(message);
              }
            } );