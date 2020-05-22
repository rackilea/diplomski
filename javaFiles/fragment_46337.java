@Value("${key that placed in property file}")
        private String file;

        @GetMapping("/file")
        @ResponseBody
        public String loadFile() throws FileNotFoundException {
         String test;
         Scanner br = new Scanner(new FileReader(file));

         StringBuilder sb = new StringBuilder();
         while (br.hasNext()) {
             sb.append(br.next());
         }
         br.close();
         test = sb.toString();

         return test;
     }