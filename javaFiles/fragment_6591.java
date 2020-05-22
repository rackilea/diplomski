@Controller
public class FileUploadController {


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model map) {

        for(MultipartFile file : uploadForm.getFiles()){
            try {
                file.transferTo(new File(targetPath+file.getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }

}