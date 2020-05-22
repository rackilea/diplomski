BufferedReader read = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                        String rea = read.readLine();
                        String[] split = rea.split(" ");
                        width =  Integer.valueOf(split[0]);
                        height = Integer.valueOf(split[1]);

                        String readline;
                        int num = 0;
                        maze1 = new char[width][height];
                        while((readline = read.readLine()) != null){
                            char[] ch = readline.toCharArray();
                            for(int i = 0;i < ch.length;i++){
                                maze1[i][num] = ch[i];
                            }
                            num++;
                        }