import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.endpoint.mvc.MvcEndpoint;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

class CustomEndpoint implements MvcEndpoint {

    @Override
    public String getPath() {
        return "/custom";
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public Class<? extends Endpoint<?>> getEndpointType() {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void invoke(HttpServletResponse response)
            throws ServletException, IOException {
        FileCopyUtils.copy(new FileInputStream(new File("c:/temp/cars.csv")),
                response.getOutputStream());
    }

}