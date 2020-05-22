@Service
public class GalleryService {

    @Autowired
    GalleryRepository galleryRepository;

    public List<Gallery> getGalleriesByCategoryName(String name) {
        return galleryRepository.findAllByCategoryName(name);
    }
}