public void updateContractDetailList() {
    List<ContractDetail> details = new ArrayList<ContractDetail>();
    List<Contract> contracts = contractService.findAll();
    List<ContractCoverParameter> contractCoverParams = findAll();

    for (Contract contract : contracts) {

        details = contract.getDetails();

        if (contract.getDetails() != null || contract.getDetails().size() != 0) {

            for (ContractCoverParameter coverParameter : contractCoverParams) {

                ContractDetail cDetail = new ContractDetail();
                cDetail.setContract(contract);
                cDetail.setCoverParameter(coverParameter);
                cDetail.setValue("");

                cDetail = contractDetailService.saveContractDetail(cDetail);

                details.add(cDetail);
                contract.setDetails(details);
            }
            contractService.updateContract(contract);
        }
    }
}