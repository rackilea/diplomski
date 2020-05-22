class MeterController {
    // ...
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "meters/notfound";
    }

    // ...

    @RequestMapping(value = "/{number}/edit", method = RequestMethod.GET)
    public String viewEdit(@PathVariable("number") final Meter meter,
                           final Model model) {
        if (meter == null) throw new ResourceNotFoundException();

        model.addAttribute("meter", meter);
        return "meters/edit";
    }
}