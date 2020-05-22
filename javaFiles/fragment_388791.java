public PageableResponse<PatientBundleType> getPatientBundles(@BeanParam final PageableBeanParam paging)
{
    ...
}

public class PageableBeanParam
{
    public PageableBeanParam(@Context final UriInfo uriInfo)
    {

        for (Entry<String, List<String>> param : params.entrySet())
        {
            String key = param.getKey();
            String value = param.getValue().iterator().next();

            if ("pageSize".equals(key))
            {
                setPageSize(Integer.valueOf(value));
            }

            ...
        }
    }
}