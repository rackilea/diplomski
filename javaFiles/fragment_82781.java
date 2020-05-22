while ((lines = br.readLine()) != null) {
                    String split[] = lines.split("#");
                    String userName = split[0];
                    Boolean admin = null;
                    if (split[1].trim().length() != 0) {
                        try {
                            admin = Boolean.parseBoolean(split[1]);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                    String password = split[2];

                    if(userName.equals(userN) && password.equals(passW)){
                        if(admin != null && admin){
                            System.out.println("He is a Admin");
                        }else{
                            System.out.println("Normal Guy"); 
                        }
                    }
                }