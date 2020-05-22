try {
                    userAnswer = Integer.parseInt(answer);//Add this line here 
                    if (userAnswer == 5) {
                        JOptionPane.showMessageDialog(null, "Good!!");
                        score = score + awarded;
                    }

                    else {
                        JOptionPane.showMessageDialog(null,
                                "Not Even Close!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("enter a number");
                }