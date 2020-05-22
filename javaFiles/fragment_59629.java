Command  prospectoCommand = new Command("Prospecto", Command.EXIT, 1);

                         StringItem messageItem2 = new StringItem("", "", Item.HYPERLINK);

                         messageItem2.setText("push to go to the URL");

ItemCommandListener listener = new ItemCommandListener() {

                    public void commandAction(Command cmnd, Item item) {

                        if(cmnd==prospectoCommand)
                        {
                            try {
                                midlet.platformRequest(URL);
                            } catch (ConnectionNotFoundException ex) {
                                ex.printStackTrace();
                            }

                        }


                    }
                };

                    messageItem2.setDefaultCommand(prospectoCommand);