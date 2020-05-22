return super.getSession().createCriteria(PpNnCtDetail.class)
    .add(Restrictions.between("commencementDate", fromDate, toDate)
    .createCriteria("nnContractTbl")
    .createCriteria("progCategory").add(Restrictions.in("progCategoryId", allProgCat))
    .createCriteria("acadOrgTbl")
    .createCriteria("serviceType")
    .createCriteria("campusTbl")
    .list();