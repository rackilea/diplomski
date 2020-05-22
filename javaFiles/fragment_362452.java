import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import javax.ws.rs.core.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

public class CacheControlCopyFilter
    implements ContainerResponseFilter 

    @Override
    public ContainerResponse filter( ContainerRequest containerRequest, ContainerResponse containerResponse ) {
        if ( containerRequest.getRequestHeader( HttpHeaders.CACHE_CONTROL ) != null ) {
            List<Object> responseCacheControlValues = new ArrayList<Object>( containerRequest.getRequestHeader( HttpHeaders.CACHE_CONTROL ).size() );
            for ( String value : containerRequest.getRequestHeader( HttpHeaders.CACHE_CONTROL ) ) {
                responseCacheControlValues.add( value );
            }
            containerResponse.getHttpHeaders().put( HttpHeaders.CACHE_CONTROL, responseCacheControlValues );
        }
        return containerResponse;
    }

}