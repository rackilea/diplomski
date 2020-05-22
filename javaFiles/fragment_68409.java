Date fdate=Date.from(finstant);
Date tdate=Date.from(tinstant);

List<OPDBill> listOfBills = mongoOperations.find(
                Query.query(Criteria.where("queryBillDate").gte(fDate).lt(tDate)), 
                OPDBill.class,
                OPDBillsCollection);