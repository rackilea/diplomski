if(vardbtype.equals("MYSQL")){
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("----------------------------");
                    int limitrowmysql = 0;
                    LocalDate now = LocalDate.now();
                    Path path = FileSystems.getDefault().getPath("C:\\Users\\NN\\Documents\\Test\\RowMYSQL\\RowIDMYSQL_" + now.format(DateTimeFormatter.ISO_LOCAL_DATE) + ".txt");
                    if (Files.exists(path)) {
                        String latestRowIdFromFile  = Files.lines(path).max((e1, e2) -> {
                        if (((String)e1).isEmpty() || ((String)e2).isEmpty()) {
                            return -1;
                        }
                        return new Long(e1).compareTo(new Long(e2));
                        }).get(); // read latestRowId from file
                        if (latestRowIdFromFile != null && !latestRowIdFromFile.isEmpty()) {
                            limitrowmysql = Integer.valueOf(latestRowIdFromFile);
                        }
                    } else {
                        limitrowmysql = 0;
                    }
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ vardbserver, vardbuser, vardbpassword);
                    while(true) {
                        Statement stmts = c.createStatement();
                        int countrowmysql = 0;
                        String sql = ("SELECT * FROM "+ vardbname +" LIMIT "+ limitrowmysql +", 18446744073709551615");
                        ResultSet rss = stmts.executeQuery(sql);
                        while(rss.next()) {
                            String  message = rss.getString("MESSAGE");
                            System.out.println("Message = " + message);
                            TextMessage mssg = session.createTextMessage(message);
                            System.out.println("Sent: " + mssg.getText());
                            producer.send(mssg);
                            countrowmysql = countrowmysql + 1;
                        }

                        rss.close();
                        stmts.close();
                        Thread.sleep(batchperiod2);

                        limitrowmysql = limitrowmysql + countrowmysql;
                        Files.write(path, ("\n" + limitrowmysql).getBytes()); // write latestRowId to file
                    }
                }