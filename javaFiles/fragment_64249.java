ChatActivity.this.runOnUiThread(new Runnable() {

                                @Override
                                public void run() {

                                    chatArrayAdapter.add(new ChatMessage(receivedUserID, receivedMessage));
                                }
                            });