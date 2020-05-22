<%String getComments = "select comment_desc,time_stamp from comments_tb where car_id = "
                                + request.getParameter("id") + "\" order by time_stamp DESC";
                        KarimDatabase karim2 = new KarimDatabase();
                        Statement stm2 = karim2.getCon().createStatement();
                        ResultSet rs2 = stm2.executeQuery(query);
                        while (rs2.next()) {
                            out.println("<p>" + rs2.getString(1) + "</p>"); //get first column result
                            out.println("<p>" + rs2.getString(2) + "</p>"); //2nd

                        }
                        karim2.getCon().close();

                    %>