import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter( ContainerRequestContext reqc , ContainerResponseContext resc ) throws IOException {
        MediaType mediaType = this.getMediaTypeFromExtentionOrHeader(); // TODO
        List<MediaType> mediaTypes = reqc.getAcceptableMediaTypes();
        if( mediaTypes.contains(mediaType) ) {   
            resc.setEntity( resc.getEntity(), new Annotation[0], mediaType );
        }
        // ...
    }
}