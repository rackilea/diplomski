private void disconnectClassOfService(List<Integer> sdidList) throws Exception {

    if (sdidList == null || sdidList.isEmpty()) {
        return;
    }

    logger.info("Start deleting sdid : " + sdidList);
    for (Integer sdid : sdidList) {

        List<CosPolicy2Interface> cosPolicy2InterfaceBySdid = getCosPolicy2InterfaceDAO().getCosPolicy2InterfaceBySdid(sdid);
        if (cosPolicy2InterfaceBySdid != null && !cosPolicy2InterfaceBySdid.isEmpty()) {

            List<CosPolicy2Interface> recordsACTIVE = new ArrayList<>();
            List<CosPolicy2Interface> recordsNonACTIVE = new ArrayList<>();

            for (CosPolicy2Interface cosPolicySdid : cosPolicy2InterfaceBySdid) {
                if (cosPolicySdid.getStatus().equals("PEND_ADD")) {
                    recordsNonACTIVE.add(cosPolicySdid);
                }
                if (cosPolicySdid.getStatus().equals("PEND_DEL")) {
                    recordsNonACTIVE.add(cosPolicySdid);
                }
                if (cosPolicySdid.getStatus().equals("ACTIVE")) {
                    recordsACTIVE.add(cosPolicySdid);
                }
            }
            if ((recordsACTIVE.size() == cosPolicy2InterfaceBySdid.size())) {
                getPersistMgr().deleteAll(cosPolicy2InterfaceBySdid);// Delete all records
            } else {
                // delete non active records
                getPersistMgr().deleteAll(recordsNonACTIVE);
            }
        }
    }
}