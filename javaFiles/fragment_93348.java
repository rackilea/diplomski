@RequestMapping(value = "/search/", method = RequestMethod.POST, headers = "Accept=application/json")
public ResponseEntity<String> getVertagFromSearch(@RequestBody String json, UriComponentsBuilder uriBuilder){
    Contract contract = contract.fromJsonToContract(json);
    List<Contract> contractList = Contract.findAllContractsPerContract(contract);
    return new ResponseEntity<String>(Contract.toJsonArray(contractList), headers, HttpStatus.OK);
}