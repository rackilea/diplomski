@RequestMapping(value = "/user/{id}")
public String show(@PathVariable Long id, Model model) {
  ...
}

//link
<a href="<c:url value='/user/${userId}'/>"> ...</a>