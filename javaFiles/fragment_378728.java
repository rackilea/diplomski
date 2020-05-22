public interface UserRepository extends PageableAndFilterableGenericRepository<User, QUser> {

QDSLAliasRegistry aliasRegistry = QDSLAliasRegistry.instance();

@Override
default void customize(QuerydslBindings bindings, QUser root) {
    bindAlias(bindings, root.account.login, "username");
}

default void bindAlias(QuerydslBindings bindings, StringPath path, String alias) {
    bindings.bind(path).as(alias).first(StringExpression::likeIgnoreCase);
    aliasRegistry.register(alias, path);
}