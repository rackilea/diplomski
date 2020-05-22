ArrayList<Integer> myVector=new ArrayList<Integer>(); 
                        myVector.add(a);
                        myVector.add(b);
                        myVector.add(day);
                        if(chckbxLei.isSelected())
                        {
                            myVector.add(lei);
                        }
                        if(chckbxAdv.isSelected())
                        {
                            myVector.add(adv);
                        }

                        Case ca= new Case();
                        try {
                            ca.addPlace(myVector);
                            LoginGUI um= new LoginGUI();
                            um.setVisible(true);

                        } catch (Exception e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }