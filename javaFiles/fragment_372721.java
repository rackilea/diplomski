for(int i=0; i<noOfEmails; i++)
        {
            if(noOfEmails==1)
            {
                for(int j=0; j<noOfQuest; j++)
                {
                    System.out.println("In Loop[" + j + "] : recipient1: "+ recipient1);


                    if(i==0)
                    {
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient1));                            
                    }
                    if(noOfQuest==1)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0]);                           
                    }
                    if(noOfQuest==2)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1]);                           
                    }
                    if(noOfQuest==3)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2]);                           
                    }
                    if(noOfQuest==4)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2] + "\n" +
                                                        "Response 4: " + answers[3]);                           
                    }
                    if(noOfQuest==5)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2] + "\n" +
                                                        "Response 4: " + answers[3] + "\n" +
                                                            "Response 4: " + answers[4]);
                    }
                }
            }   

            if(noOfEmails==2)
            {
                for(int k=0; k<noOfQuest; k++)
                {
                    System.out.println("In Loop[" + k + "] : recipient2: "+ recipient2);

                    if(i==0)
                    {
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient1));
                    }
                    if(i==1)
                    {
                        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient2));
                    }
                    if(noOfQuest==1)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0]);                               
                    }
                    if(noOfQuest==2)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1]);                               
                    }
                    if(noOfQuest==3)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2]);                               
                    }
                    if(noOfQuest==4)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2] + "\n" +
                                                        "Response 4: " + answers[3]);                               
                    }
                    if(noOfQuest==5)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2] + "\n" +
                                                        "Response 4: " + answers[3] + "\n" +
                                                            "Response 4: " + answers[4]);                               
                    }
                }
            }

            if(noOfEmails==3)
            {
                if(i==0)
                {
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient1));
                    System.out.println(recipient1);
                }
                if(i==1)
                {
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient2));
                    System.out.println(recipient2);
                }
                if(i==2)
                {
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient3));
                    System.out.println(recipient3);
                }

                for(int l=0; l<noOfQuest; l++)
                {
                    System.out.println("In Loop[" + l + "] : recipient3: "+ recipient3);


                    if(noOfQuest==1)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0]);                               
                    }
                    if(noOfQuest==2)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1]);                               
                    }
                    if(noOfQuest==3)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2]);                               
                    }
                    if(noOfQuest==4)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2] + "\n" +
                                                        "Response 4: " + answers[3]);                               
                    }
                    if(noOfQuest==5)
                    {
                        message.setText("Username: " + fName + " "+ sName + "\n" +
                                            "Response 1: " + answers[0] + "\n" +
                                                "Response 2: " + answers[1] + "\n" +
                                                    "Response 3: " + answers[2] + "\n" +
                                                        "Response 4: " + answers[3] + "\n" +
                                                            "Response 4: " + answers[4]);
                    }
                }
            }
            Transport.send(message);
            System.out.println("Sent: " + message);
        }