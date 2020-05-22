@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity<?> getById(@PathVariable int id)
{

    Flight fl = repo.findById(id);
    if (fl==null)
        return new ResponseEntity<String>("Flight not found",HttpStatus.NOT_FOUND);
    else
        return new ResponseEntity<Flight>(fl, HttpStatus.OK);
}