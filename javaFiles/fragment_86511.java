@GetMapping("movies/{movieId}/actors")
public ResponseEntity<Page<Actor>> getAllActorsFromMovieByIdMovie(@PathVariable(name = "movieId") Long movieId,
                                                                  @RequestParam(name = "name", required = false) String name,
                                                                  Pageable pageable) {
    Optional<Movie> movieFromDataBase = movieService.findMovieById(movieId);
    if (movieFromDataBase.isPresent()) {
        return new ResponseEntity<>(actorService.findAllActors(ActorSpec.query(movieId ,name), pageable), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}