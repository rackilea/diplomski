ConfigurationSection section = config.getConfigurationSection("data");
        if (section != null) {
            Set<String> datas = section.getKeys(false);
            if (datas != null && !datas.isEmpty()) {
                for (String uuid : datas) {
                    ConfigurationSection section2 = config.getConfigurationSection("data." + uuid);
                    if (section2 != null) {

                    getDataList().add(section2.getString("name"));

                    }
                }
            }
        }
        System.out.println(datalist);