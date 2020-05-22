public class FileWrapper implements Iterable<String> {

    private File file;
    // Keep track of phantom references to iterators
    private static ReferenceQueue<Itr> references = new ReferenceQueue<>();
    static {
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    // Block until an iterator is about to be annihilated
                    Reference<Itr> ref = references.remove();
                    Itr aboutToDie = ref.get();
                    try {
                        aboutToDie.scanner.close();
                    }
                    catch(IOException ex) {
                        // Already closed?
                    }
                }
            }
        }).start();
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {

        private Scanner scanner;

        public Itr() throws FileNotFoundException {
            scanner = new Scanner(file);
            synchronized(references) {
                new PhantomReference(scanner, references);
            }
        }

        @Override
        public boolean hasNext() {
            return scanner.hasNextLine();
        }

        @Override
        public String next() {
            return scanner.nextLine();
        }
    }
}