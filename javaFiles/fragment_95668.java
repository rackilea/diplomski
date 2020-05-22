@ExceptionHandler(EntityNotFoundException.class)
public String redirectOnEntityNotFoundException(final EntityNotFoundException exception, 
                                                final RedirectAttributes redirectAttributes) {
    alertHandler.set(redirectAttributes, Status.ENTITY_NOT_FOUND);
    return exception.getFallbackView();
}