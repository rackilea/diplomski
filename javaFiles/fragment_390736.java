//Insert post in flow 
@RequestMapping(value="/posts", method = RequestMethod.POST)
public Post postInsert(@RequestBody Post post) {

// you have to use your repository to be able to CRUD operations in the store

final PostRepository postRepository;    

// save the post in the store

postRepository.save(new Post(counter.incrementAndGet(), post.getContent(), post.getTime(), post.getGender(), post.getAge()));

HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.setLocation(ServletUriComponentsBuilder
            .fromCurrentRequest().build().toUri());

return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
}