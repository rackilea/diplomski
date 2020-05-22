public static class InputData
{
    private String name

    public String getName()
    {
        return name;
    }

    public void setName(final String name
    {
        this.name = name;
    }
}

@RequestMapping(value = "/downloadByCode", method = RequestMethod.POST)

@ResponseBody
public void downloadByCode(@RequestBody final InputData request, final HttpServletResponse response)
{
    try
    {
        String codes = request.getName();

        // ...
        // some processings here to create the result
        // ....

        final ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result);
        // Flush the result
        outputStream.flush();
    }
    catch (final Exception exception)
    {
        LOG.debug("Exception Thrown [downloadByCode]", exception);
    }
}