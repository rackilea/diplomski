InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
Stream lines = br.lines();
Consumer processFile = new Consumer() {
    public void accept(Object o) {
        File xmlFile = new File(o.toString());
        // Do SOMETHING with xmlFile
    }
};
lines.forEach(processFile);