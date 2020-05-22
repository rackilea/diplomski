if(senderNum.equals("345"))
                    {   
                        Intent successScreen= new Intent(context, SuccessActivity.class);
                        successScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        successScreen.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
successScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        context.startActivity(successScreen);

                    }   
                    else if(senderNum.equals("3450") || senderNum.equals("3451") || senderNum.equals("3452")){

                        Intent alertActivity = new Intent(context, FailureActivity.class);
                        alertActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  successScreen.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
successScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        context.startActivity(alertActivity);
                  }