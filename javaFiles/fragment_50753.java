public class Store {
    private final List<String> storeList;

    @Autowired
    public Store(@Value("${store.file.path}") String storeFilePath) throws IOException {
            File file = new File(storeFilePath);
            storeList = Files.readAllLines(file.toPath());
    }
}