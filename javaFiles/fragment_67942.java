User user = // allocate your user;
Permissao permissao = // allocate the permission you wish to remove

user.setPermissao(user.getPermissao().remove(permissaio);

then save the user object through saveOrUpdate() or Update() function.