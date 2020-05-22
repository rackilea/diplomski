@SpringBootApplication
public class So45179111Application {

    public static void main(String[] args) {
        SpringApplication.run(So45179111Application.class, args);
    }

    public static class ListToCommaTextConverter implements AttributeConverter<List<String>, String> {

        @Override
        public String convertToDatabaseColumn(List<String> attribute) {
            if (attribute == null || attribute.isEmpty()) {
                return null;
            }

            return attribute.stream().collect(Collectors.joining(","));
        }

        @Override
        public List<String> convertToEntityAttribute(String dbData) {
            if (dbData == null || dbData.isEmpty()) {
                return Collections.emptyList();
            }
            return Stream.of(dbData.split(",")).collect(Collectors.toList());
        }
    }

    @Entity
    @Table(name = "Movies")
    public static class MoviesInfo extends AbstractPersistable<Long> {
        private String name;
        // getters and setters
    }

    @Entity
    @Table(name = "Songs")
    public static class SongsInfo extends AbstractPersistable<Long> {
        @Column(columnDefinition = "text")
        @Convert(converter = ListToCommaTextConverter.class)
        private List<String> singers;

        @Column(columnDefinition = "text")
        @Convert(converter = ListToCommaTextConverter.class)
        private List<String> lyricists;

        @Column(columnDefinition = "numeric(3,2)")
        private float length;

        private int year;

        @ManyToOne
        @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "Songs_Movies_fk1"))
        private MoviesInfo movie;

        // getters and setters
    }

    @RestController
    @RequestMapping("/songs")
    public static class SongsApi {

        private final SongsInfoRepository songsInfoRepository;

        @Autowired
        public SongsApi(SongsInfoRepository songsInfoRepository) {
            this.songsInfoRepository = songsInfoRepository;
        }

        @PostMapping
        public SongsInfo store(@RequestBody SongsInfo songsInfo) {
            return songsInfoRepository.save(songsInfo);
        }
    }
}

interface SongsInfoRepository extends CrudRepository<So45179111Application.SongsInfo, Long> {}