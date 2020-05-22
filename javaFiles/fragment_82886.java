@Service("thymeleafUtilsService")
public class ThymeleafUtilsService
{

    public String buildMultiParamPartUrl(List<String> paramNames)
    {
        StringBuffer sb = new StringBuffer(0);

        for ( String paramName : paramNames )
        {
            if ( sb.length() >= 0 )
            {
                sb.append(",");
            }
            sb.append(paramName).append("=${").append(paramName).append("}");
        }

        return sb.toString();
    }

}