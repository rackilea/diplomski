public static void main(String[] argumentos) throws Exception{
        File file = new File("C:\\app\\daily.log");
        List<String> lines = FileUtils.readLines(file);

        Map<String,Long> start = new HashMap();
        Map<String,Long> end = new HashMap();
        Map<String,Long> init = new HashMap();
        List<String> beans = new ArrayList();
        int max = 0;

        for(String line :  lines) {
            String time = StringUtils.substring(line, 0, 9);
            String msg = StringUtils.substring(line, 10);

            if(msg.startsWith("Creating instance")) {
                int fi = StringUtils.indexOf(msg, '\'') + 1;
                int li = StringUtils.lastIndexOf(msg, '\'');
                String bean = StringUtils.substring(msg, fi, li);
                if(start.containsKey(bean)) {
                    continue;
                }
                start.put(bean, parseTime(time));
                beans.add(bean);
                max = Math.max(max, bean.length());

            } else if(msg.startsWith("Finished creating")) {
                int fi = StringUtils.indexOf(msg, '\'') + 1;
                int li = StringUtils.lastIndexOf(msg, '\'');
                String bean = StringUtils.substring(msg, fi, li);
                if(end.containsKey(bean)) {
                    continue;
                }
                end.put(bean, parseTime(time));

            } else if(msg.startsWith("Init time for")) {
                int li = StringUtils.lastIndexOf(msg, ':');
                String bean = StringUtils.substring(msg, 14, li);
                if(init.containsKey(bean)) {
                    continue;
                }
                init.put(bean, Long.parseLong(StringUtils.substring(msg, li+2)));
            }
        }

        for(String bean : beans) {
            long s = start.get(bean);
            long e = end.get(bean);
            long i = init.containsKey(bean) ? init.get(bean) : -1;
            System.out.println(StringUtils.leftPad(bean, max) + ": " + StringUtils.leftPad(Long.toString((e-s)+i), 6, ' '));
        }
    }