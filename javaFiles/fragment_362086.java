static final List<String> THREADS = new ArrayList<String>();

// ...

for (Element src : threads){
    String title = src.text();
    String href = src.attr("href");
        THREADS.add(title);
}