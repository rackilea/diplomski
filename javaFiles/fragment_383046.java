@RequestMapping(method = RequestMethod.PUT, path = "/addComment/{id}")
public Ticket addComment(@PathVariable(value = "id") String id, @RequestBody AddCommentRequest comment) {
    Ticket ticket = repository.findOne(id);
    ticket.addComment(comment.message);
    return repository.save(ticket);
}