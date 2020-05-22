/**
 * GET  /account -> get the current user.
 */
@RequestMapping(value = "/account",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Timed
public ResponseEntity<UserDTO> getAccount() {
    UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    List<String> roles = new ArrayList<>();
    for (GrantedAuthority authority : userDetails.getGrantedAuthorities()) {
        roles.add(authority.getAuthorigy());
    }
    return new ResponseEntity<>(
        new UserDTO(
            user.getLogin(),
            null,
            null,
            null,
            null,
            null,
            roles),
        HttpStatus.OK);
}