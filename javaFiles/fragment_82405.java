DisplayEmpData() {

        l0 = new JLabel("Fatching Employee Information");
        l0.setForeground(Color.red);
        l0.setFont(new Font("Serif", Font.BOLD, 20));
        l1 = new JLabel("Select name");
        b1 = new JButton("submit");

        l0.setBounds(100, 50, 350, 40);
        l1.setBounds(75, 110, 75, 20);
        b1.setBounds(150, 150, 150, 20);
        b1.addActionListener(this);

        setTitle("Fetching Student Info From DataBase");
        setLayout(null);

        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(l0);
        add(l1);;
        add(b1);
        try {

            Vector v = new Vector();

            String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "C:\\users\\ppreeti\\emp_details.accdb";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection(url,"","");
            /*con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");*/
            st = con.createStatement();
            rs = st.executeQuery("select uname from emp");

            while (rs.next()) {
                ids = rs.getString(1);
                v.add(ids);
            }
            c1 = new JComboBox(v);
            c1.setBounds(150, 110, 150, 20);

            add(c1);
            st.close();
            rs.close();
        } catch (Exception e) {
        }

        setVisible(true);
    }