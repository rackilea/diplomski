FileInputStream wf = new FileInputStream(pr.getSplitDir() + listfiles[i]);
        BufferedReader wbf = new BufferedReader(new InputStreamReader(wf));
        String wfl = "";
        StringBuilder sb = new StringBuilder();
        while ((wfl = wbf.readLine()) != null) {
            if(wfl.contains("A/C NO:")){
                //System.out.println(wfl);//Here it is Printing the correct line
                sb.append(wfl);
            }
        }
        System.out.println(sb.toString());//Here it is printing null