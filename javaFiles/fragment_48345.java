@RequestMapping(value = "/person/loadProponents/{idPerson}", method = RequestMethod.GET)
public @ResponseBody DatatablesResponse<Proposal> loadProponents(@PathVariable("idPerson") Long idPerson, HttpServletRequest request) {
   DatatablesCriterias criterias = DatatablesCriterias.getFromRequest(request);
   DataSet<Proposal> dataset = proposalService.getProposalsDataset(criterias);
   return DatatablesResponse.build(dataset, criterias);
}