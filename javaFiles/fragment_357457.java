<% 
 String className = doc.get("entryClassName");
 Long classPk = Long.parseLong( doc.get("entryClassPK") );
 
 AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(className, classPk);
 Long assetEntryId = assetEntry.getEntryId();
 
 webContentPortletURL = PortletURLFactoryUtil.create(request, portletId, specificPlid, PortletRequest.RENDER_PHASE);
 webContentPortletURL.setParameter( "struts_action", "/asset_publisher/view_content" ); 
webContentPortletURL.setParameter( "groupId", String.valueOf(articleGroupId) );
webContentPortletURL.setParameter( "type", "content" );
webContentPortletURL.setParameter( "assetEntryId", String.valueOf(assetEntryId) );
webContentPortletURL.setParameter( "articleId", articleId );  
 %>