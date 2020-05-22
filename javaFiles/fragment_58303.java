public String getButtonId(SapToolbarControl toolbar, int position)
{
    Object[] params = new Object[1];
    params[0] = position;
    Object buttonId = toolbar.invoke("GetButtonId", params);
    return (String) buttonId;
}