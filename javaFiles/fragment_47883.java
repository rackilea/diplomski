// ...
    // ...
    // ...
    add.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            if (viewpanel.isShowing())
            {
                remove(viewpanel);
                /*
                 * I basically just added this one line.
                 * Since you want to make a fresh query after
                 * you come back to the viewpanel, we can delete
                 * all the elements (which is only the JTable).
                 */
                viewpanel.removeAll();
                add(addpanel);
            }

            revalidate();
            repaint();
        }
    });

    view.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            java.util.List<String[]> datalist = new ArrayList<>();

            String[] columnNames = {"Emp ID", "Emp Name", "Department",
                    "Basic Pay", "House Allowance", "Payee", "NHIF", "NSSF",
                    "Pension", "NetPay"};
            try
            {
                //                    String query = "SELECT * FROM payroll";
                //                    Class.forName("com.mysql.jdbc.Driver");
                //                    Connection con = DriverManager.getConnection(host, username,
                //                            password);
                //                    Statement st = con.prepareStatement(query);
                //                    ResultSet rs = st.executeQuery(query);
                String[] results = {"a", "b", "c", "d", "e", "f", "g", "h",
                        "i", "j"};
                datalist.add(results);
                //                    con.close();
                String[][] data = new String[datalist.size()][];
                data = datalist.toArray(data);
                JTable table = new JTable(data, columnNames);

                JScrollPane sp = new JScrollPane(table);
                viewpanel.add(sp);

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            if (addpanel.isShowing())
            {
                remove(addpanel);
                add(viewpanel);
            }
            else if (viewpanel.isShowing())
            {
                remove(viewpanel);
                add(viewpanel);
            }

            revalidate();
            repaint();
        }
    });
    // ...
    // ...
    // ...