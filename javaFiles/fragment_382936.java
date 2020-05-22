String cookie = null;
if(response.getFirstHeader("Cookie") != null)
{
cookie = response.getFirstHeader("Cookie")
                    .getValue();
}