<%   
 ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
 Object[] objArray = (Object[])row.getObject();
 Document doc = (Document)objArray[1];
 
 String layoutUuid = doc.get("layoutUuid");
 
 Layout specificLayout = LayoutLocalServiceUtil.getLayoutByUuidAndCompanyId( layoutUuid, PortalUtil.getDefaultCompanyId() );
 
specificPlid = specificLayout.getPlid();    
articleLayoutTypePortlet = (LayoutTypePortlet) specificLayout.getLayoutType();

List<Portlet> allPortlets = articleLayoutTypePortlet.getAllPortlets();
for (Portlet portlet : allPortlets){
         if ( PortletKeys.ASSET_PUBLISHER.equals( portlet .getRootPortletId() ) ) {
                portletId = PortletKeys.ASSET_PUBLISHER + PortletConstants.INSTANCE_SEPARATOR + portlet .getInstanceId();
                break;
         }
}
%>