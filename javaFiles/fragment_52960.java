@ApiOperation(value = "Update Developer (dev)",
        response = ResponseEntity.class)
@RequestMapping(method = RequestMethod.PATCH,
        value = "/{type:developer}")
public ResponseEntity<Response> updateDeveloper(
        @PathVariable String type,
        @RequestParam("year") String year,
        @RequestBody Developer employeeUpdate,

) { .....}

@ApiOperation(value = "Update Manager (manager)",
        response = ResponseEntity.class)
@RequestMapping(method = RequestMethod.PATCH,
        value = "/{type:manager}")
public ResponseEntity<Response> updateManager(
        @PathVariable String type,
        @RequestParam("year") String year,
        @RequestBody Manager employeeUpdate,

) { .....}