JavaRDD<String> newLine = line.flatMap(new FlatMapFunction<String, String>() {
        public Iterator<String> call(String s) throws Exception {
            List<String> ret = new ArrayList<String>();
            List<String> ls = Arrays.asList(s.split("\t"));

            String values = ls.get(ls.size()-1);
            List<String> value = Arrays.asList(values.split("\\|"));

            for(int i=0;i<value.size();++i){
                String ns = ls.get(0)+"\t"+ls.get(1)+"\t"+ls.get(2)+"\t"+ls.get(3)+"\t"+ls.get(4)+"\t"+ls.get(5);
                ns = ns + "\t" + value.get(i);
                ret.add(ns);
            }
            return ret.iterator();
        }
    });