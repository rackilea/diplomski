@Override
    public boolean deleteGroupSection(int sectionId, int mcanvasId) {
        try {
            GroupCanvas groupCanvas = this.groupCanvasService.getCanvasById(mcanvasId);
            Long groupAccountId = this.groupAccountService.getGroupById(groupCanvas.getGroupAccountId()).getGroupId();
            this.groupAttachmentsService.deleteAttachmentsForSection(sectionId,groupAccountId);
        }catch (Exception ignored){}

        this.groupSectionDAO.deleteGroupSection(sectionId,mcanvasId);

        for(Iterator<GroupSection> it = groupCanvas.getGroupSections().iterator(); it.hasNext();){
            GroupSection gs = it.next();
            if(gs.getId().equals(sectionId)){
                it.remove(gs);
            }
        }
        return true;
    }