import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static class EntityVisibility {
        public static class Public { }
        public static class Detailed extends Public { }
        public static class Internal extends Detailed { }
    }

    @RestController
    public static class MyRestController {

        @JsonView(EntityVisibility.Public.class)
        @RequestMapping(value="/", method= RequestMethod.GET)
        public Response<Photo> loadFromUrl() {

            Photo photo = new Photo(); // create photo object
            photo.setB64content("dfgsdfgsdfg");
            photo.setMime_type("image/png");
            System.out.println(photo);
            return new Response<>(photo);
        }
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Response<T> {
        @JsonView(EntityVisibility.Public.class)
        private T result;

        @JsonView(EntityVisibility.Public.class)
        private boolean success = true;

        @JsonView(EntityVisibility.Public.class)
        private Object error;

        @JsonView(EntityVisibility.Public.class)
        private String errorCode;

        @JsonView(EntityVisibility.Public.class)
        private String message;

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }

        public Response(T response) {
            result = response;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Object getError() {
            return error;
        }

        public void setError(Object error) {
            this.error = error;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class Photo extends Entity {

        @JsonIgnore
        protected byte[] content;

        @JsonView(EntityVisibility.Public.class)
        private Date modified;

        @JsonView(EntityVisibility.Public.class)
        private String mime_type;

        @JsonProperty("content")
        @JsonView(EntityVisibility.Internal.class)
        public void setB64content(String b64content) {
            this.content = (b64content == null) ? null : b64content.getBytes();
        }

        public String getB64content() {
            return (content.length == 0) ? null : Base64.encode(content);
        }

        public byte[] getContent() {
            return content;
        }

        public void setContent(byte[] content) {
            this.content = content;
        }

        public Date getModified() {
            return modified;
        }

        public void setModified(Date modified) {
            this.modified = modified;
        }

        public String getMime_type() {
            return mime_type;
        }

        public void setMime_type(String mime_type) {
            this.mime_type = mime_type;
        }

        @Override
        public String toString() {
            return "Photo{" +
                    "content=" + Arrays.toString(content) +
                    ", modified=" + modified +
                    '}';
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Entity {

    }
}