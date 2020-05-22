`try {

                String gdbcommand = "/data/bin/gdb  " + pidsII + " " + pidsII + " < somefile.txt";

                String line;

                ArrayList<String> lines = new ArrayList<String>();

                Process process = Runtime.getRuntime().exec("su");

                if (process != null){
                    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(process.getOutputStream())),true);

                    out.println(gdbcommand);

                    out.flush();

                    out.flush();

                    out.close();

                    while ((line = in.readLine()) != null){

                        lines.add(line);

                    } 

                    String[] lineArray = new String[lines.size()];
                    lineArray  = lines.toArray(lineArray);

                    for (int i=0; i < lineArray.length; i++) {
                        System.out.println(lineArray[i].toString());
                    }
                    process.destroy();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }`