for (Cookie c : requestContext.getCookies().values()) 
{
    if (c.getName().equals("token")) {
        cookie = c;
        break;
    }
}