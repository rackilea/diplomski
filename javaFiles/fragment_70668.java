List resultWithAliasedBean = session.createQuery(
  "SELECT p.*, count(p.id), sqrt(1+2) as distance FROM post p group by p.id")
  .setResultTransformer(Transformers.aliasToBean(DTO.class))
  .list();

DTO dto = (DTO) resultWithAliasedBean.get(0);