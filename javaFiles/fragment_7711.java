HashMap<String, String> sampleObjectMap = new HashMap<String, String>();

            titles[i-1]=**sampleObjectMap.put("title", dh.val1(i-1))**;
            persons[i-1]=**sampleObjectMap.put("person", dh.pers(i-1))**;
            priorities[i-1]=**sampleObjectMap.put("priorty", setpriority(String.valueOf(dh.getpriority(i-1))))**;
            dates[i-1]=**sampleObjectMap.put("dat", getDate(Long.valueOf(dh.time(i-1)),"dd/MM/yyyy"))**;