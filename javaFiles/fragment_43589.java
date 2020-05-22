String[] mod = new String[size+1];
                mod[0] = "select value";
                for (int i = 0; i < parseObjects.size(); i++) {
                    mod[i+1] = parseObjects.get(i).getString("Hospital");
                    System.out.println(mod[i+1]);
                }