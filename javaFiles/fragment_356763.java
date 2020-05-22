@GetMapping("/all")
public List<Chbyphone_current> getAllUsers(
            @RequestParam Optional<String> active_from,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy) {

    return cbpc.findByDate(active_from.orElse("_"),
             PageRequest.of(
                    page.orElse(0), 1000,
                    Sort.Direction.ASC, sortBy.orElse("id")))
             .getContent();
}