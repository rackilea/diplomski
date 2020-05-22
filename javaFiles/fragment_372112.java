public class SimpleTable {
    private final List<RandomAccessFile> files = new ArrayList<RandomAccessFile>();
    private final List<FloatBuffer> buffers = new ArrayList<FloatBuffer>();
    private final File baseDir;
    private final int rows;

    private SimpleTable(File baseDir, int rows) {
        this.baseDir = baseDir;
        this.rows = rows;
    }

    public static SimpleTable create(String baseName, int rows) throws IOException {
        File baseDir = new File(baseName);
        if (!baseDir.mkdirs()) throw new IOException("Failed to create " + baseName);
        PrintWriter pw = new PrintWriter(baseName + "/rows");
        pw.println(rows);
        pw.close();
        return new SimpleTable(baseDir, rows);
    }

    public static SimpleTable load(String baseName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(baseName + "/rows"));
        int rows = Integer.parseInt(br.readLine());
        br.close();
        File baseDir = new File(baseName);
        SimpleTable table = new SimpleTable(baseDir, rows);
        File[] files = baseDir.listFiles();
        Arrays.sort(files);
        for (File file : files) {
            if (!file.getName().endsWith(".float")) continue;
            table.addColumnForFile(file);
        }
        return table;
    }

    private FloatBuffer addColumnForFile(File file) throws IOException {
        RandomAccessFile rw = new RandomAccessFile(file, "rw");
        MappedByteBuffer mbb = rw.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, rows * 8);
        mbb.order(ByteOrder.nativeOrder());
        FloatBuffer db = mbb.asFloatBuffer();
        files.add(rw);
        buffers.add(db);
        return db;
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return buffers.size();
    }

    public FloatBuffer addColumn() throws IOException {
        return addColumnForFile(new File(baseDir, String.format("%04d.float", buffers.size())));
    }

    public FloatBuffer getColumn(int n) {
        return buffers.get(n);
    }

    public void close() throws IOException {
        for (RandomAccessFile file : files) {
            file.close();
        }
        files.clear();
        buffers.clear();
    }
}

public class SimpleTableTestMain {
    public static void main(String... args) throws IOException {
        long start = System.nanoTime();
        SimpleTable st = SimpleTable.create("test", 3 * 1000 * 1000);
        for (int i = 0; i < 50; i++) {
            FloatBuffer db = st.addColumn();
            for (int j = 0; j < db.capacity(); j++)
                db.put(j, i + j);
        }
        st.close();

        long mid = System.nanoTime();

        SimpleTable st2 = SimpleTable.load("test");
        for (int i = 0; i < 50; i++) {
            FloatBuffer db = st2.getColumn(i);
            double sum = 0;
            for (int j = 0; j < db.capacity(); j++)
                sum += db.get(j);
            assert sum > 0;
        }

        long end = System.nanoTime();
        System.out.printf("Took %.3f seconds to write and %.3f seconds to read %,d rows and %,d columns%n",
                (mid - start) / 1e9, (end - mid) / 1e9, st2.rows(), st2.columns());
        st2.close();
    }
}