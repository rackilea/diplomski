@Autowired ObjectMapper objectMapper;
@Autowired UserRepository userRepository;

@RequestMapping(value = "/{id}", method = RequestMethod.POST )
public @ResponseBody ResponseEntity<User> update(@PathVariable Long id, HttpServletRequest request) throws IOException
{
    User user = userRepository.findOne(id);
    User updatedUser = objectMapper.readerForUpdating(user).readValue(request.getReader());
    userRepository.saveAndFlush(updatedUser);
    return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
}