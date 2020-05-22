menuItemBalanceSheet.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            balanceFrame = new BalanceFrame("BalanceSheet", value);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        balanceFrame.setSize(1200, 600);
                        balanceFrame.setVisible(true);  
                        balanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                });

                menuItemCompanyValue.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            valueFrame = new ValueFrame("Company Value", value);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        valueFrame.setSize(1200, 600);                      
                        valueFrame.setVisible(true);    
                        valueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        value.
                    }
                });