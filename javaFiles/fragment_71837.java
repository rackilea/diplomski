while(((line = in.readLine()) != null))
        {
            line = in.readLine();
            String[] val = line.split("<>");
            String ID = val[0];
            String name = val[1];

            instructors.put(ID, name);
        }