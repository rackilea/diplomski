import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(SC_FORBIDDEN); /* You can also call an access denied handler here and let it handle some meaningful exception that you pass into the handle method. */
    }
}