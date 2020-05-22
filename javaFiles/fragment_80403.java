public Map<String, String> fileViewUrl(List<DLFileEntry> entries,
        HttpServletRequest request) {
    Map<String, String> urls = new HashMap<String, String>();

    for (DLFileEntry fileEntry : entries) {

        PortletURL myUrl = PortletURLFactoryUtil.create(request, "20",
                themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        try {
            myUrl.setWindowState(WindowState.NORMAL);
        } catch (WindowStateException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            myUrl.setPortletMode(PortletMode.VIEW);
        } catch (PortletModeException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(myUrl.toString());
        sb.append("&_20_struts_action=%2Fdocument_library%2Fview_file_entry&_20_fileEntryId=");
        sb.append(fileEntry.getFileEntryId());
        urls.put(fileEntry.getTitle(), sb.toString());
    }

    return urls;

}