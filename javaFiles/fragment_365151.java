boolean hasAuthorityAdmin = false;

hasAuthorityAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(AuthoritiesConstants.ADMIN);
if (hasAuthorityAdmin) {
    return "redirect:/admin/";
}
return "redirect:/user/";