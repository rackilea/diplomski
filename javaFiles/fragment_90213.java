@Provider
@PreMatching
public class JsonPatchEnableFilter implements ContainerRequestFilter
{
    @Override
    public void filter( ContainerRequestContext ctx ) throws IOException
    {
        if ( ctx.getMethod().equals( HttpMethod.PATCH )
                && MediaType.APPLICATION_JSON_PATCH_JSON_TYPE.isCompatible( ctx.getMediaType() ) )
        {
            ctx.setMethod( "JSONPATCH" );
        }
    }
}