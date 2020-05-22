Optional<Event> optionalEvent= this.eventRepository.findById(id);
    if (!optionalEvent.isPresent()) {
        throw new ResourceNotFoundException("Event with id " + id + " not found.");
    }
 Event event=optionalEvent.get();
 //the rest of your logic