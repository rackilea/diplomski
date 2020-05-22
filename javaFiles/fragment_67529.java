b6.addActionListener (new ActionListener ()
        {
            JFrame f4=new JFrame("Are you sure?");
            JPanel p4=new JPanel();
            JButton yes=new JButton ("Yes");
            JButton no=new JButton ("No");
            public void actionPerformed (ActionEvent e)
            {
                p4.add (yes);
                p4.add (no);
                f4.add (p4);
                f4.setVisible (true);
                f4.setSize (300,200);
                try {
                    yes.addActionListener (new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent e)
                            {
                                try
                                {
                                    rs.deleteRow();
                                    rs.close();
                                    st.close();
                                    st=conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs. CONCUR_UPDATABLE);
                                    String sql="select * from trial1";
                                    rs= st.executeQuery (sql);
                                    rs.next();
                                    t.setText (rs.getString ("Firstname"));
                                    t1.setText (rs.getString ("Lastname"));
                                    f4.dispose();
                                }
                                catch (Exception ex)
                                {
                                }
                            }
                        });

                    no.addActionListener (new ActionListener ()
                        {
                            public void actionPerformed (ActionEvent e)
                            {
                                f4.dispose();
                            }
                        });

                }
                catch (Exception ex)
                {
                }

            }
        });