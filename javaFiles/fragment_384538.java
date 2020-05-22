import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "/save")
    public String handleUpload(
            @RequestParam(value = "file", required = false) MultipartFile multipartFile,
            HttpServletResponse httpServletResponse) {

        String orgName = multipartFile.getOriginalFilename();

        String filePath = "/my_uploads/" + orgName;
        File dest = new File(filePath);
        try {
            multipartFile.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "File uploaded failed:" + orgName;
        } catch (IOException e) {
            e.printStackTrace();
            return "File uploaded failed:" + orgName;
        }
        return "File uploaded:" + orgName;
    }
}