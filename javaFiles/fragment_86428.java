List<Object[]> loanEntries = new ArrayList<>();
        loanEntries.add(new Object[]{"a","b","c","d",null,"f"});
        loanEntries.add(new Object[]{"aa","bb","cc","dd",null,"ff"});

        loanEntries.stream()
                .filter(objects -> objects[4] == null)
                .forEach(objects -> objects[4] = "System");

        loanEntries.stream()
                .forEach(objects -> {
                    for (Object object : objects) {
                        System.out.println(object);
                    }
                });