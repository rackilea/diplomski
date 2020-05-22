public static Ini copyIniFile(Ini originalFile){
        Set<Entry<String, Section>> entries = originalFile.entrySet();
        Ini emptyFile;
        try {
            FileInputStream file = new FileInputStream(new File(EMPTY_DATA_FILE_NAME));
            emptyFile = new Ini(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        for(Entry<String, Section> entry : entries){
            String key = (String) entry.getKey();
            Section section = (Section) entry.getValue();
            copySection(key, section, emptyFile);
        }

        return emptyFile;
    }

    public static Ini.Section copySection(String key, Ini.Section origin, Ini destinationFile){
        Ini.Section newSection = destinationFile.get(key);
        if(newSection==null) throw new IllegalArgumentException();
        for(Entry<String, String> entry : origin.entrySet()){
            newSection.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return newSection;
    }