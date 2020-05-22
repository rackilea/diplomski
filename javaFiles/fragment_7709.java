Connection conn = db.connectToAndQueryDatabase("test", "root", "root");
                System.out.println("connection established");

                Statement st = conn.createStatement();
                String query = "SELECT id, name, job_id, location FROM person WHERE name = 'Tom Swift'";
                st.executeQuery(query);