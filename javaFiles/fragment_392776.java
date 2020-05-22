public class OnlyForImagesFileWrapper {
    @Extensions(imageFormats = {".jpg",".png",".gif",".bmp"}, videoFormats = {})
    private MultipartFile file;
    private String name;
...
}