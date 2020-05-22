@RequestMapping(value = "/customers/{custId}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteCust(@PathVariable int custId) {
    return cRep.findById(custId)
               .map(cust1 -> {cRep.delete(cust1); return ResponseEntity.ok().build();})
               .orElseThrow(() -> new ResourceNotFoundException("custId " + custId + " not found"));
}