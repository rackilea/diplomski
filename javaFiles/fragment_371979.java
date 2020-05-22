List<Dentry> studentList = new ArrayList<Dentry>();
        while ((readLine = bufReader.readLine()) != null) {
            String[] splitData = readLine.split(";");

            Dentry dentry = new Dentry();
            dentry.setName(splitData[0]);
            dentry.setNumbers(Arrays.copyOfRange(splitData, 1, splitData.length));
            studentList.add(dentry);
        }