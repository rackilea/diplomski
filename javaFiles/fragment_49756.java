@Controller
public class FileController {

    @ResponseBody
    @RequestMapping("/{filename}")
    public void download(@PathVariable String filename, ServletResponse response) throws Exception {
        MyFile file = MyFile.find(filename);
        response.setContentType(file.getContentType());
        response.getOutputStream().write(file.getBytes());

    }


}