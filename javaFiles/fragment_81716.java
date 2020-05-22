public class ViewAllAsset extends Action {

    @SuppressWarnings("unused")
    public ActionForward execute(ActionMapping mapping , ActionForm form , 
            HttpServletRequest request , HttpServletResponse response)
    throws Exception{
        //HttpSession page_session = request.getSession(true);
        //String entity_id = page_session.getAttribute("entity_id").toString();
        List<Asset> result = null;
        String target = null;
        welcomeForm wForm = (welcomeForm)form;
        String entity_id = wForm.getEntity_id();
        AssetDataDAO ad = new AssetDataDAO();
        result = ad.GetAssetList(entity_id);                            /*Fetch the list*/
        List<Asset> asl = new ArrayList<Asset>();

        for(int i=0;i< result.size();i++) {
                Asset veh = new Asset();  
                veh.setAssetId(result.get(i).getAssetId());       /*set the asset POJO */
                veh.setEntityId(result.get(i).getEntityId());
                veh.setAssetTypeId(result.get(i).getAssetTypeId());
                veh.setFuelType(result.get(i).getFuelType());
                asl.add(veh);
        }
        if(result != null)
            target = "success";
        else
            target = "failure"; 

        request.setAttribute("AssetsList", asl);


    return mapping.findForward(target);    

}