final Stream<LdapAttributes> stream = LdifUtils.read(path).stream();
final Predicate<LdapAttributes> isEnabled = entry -> entry.get("pwdAccountLockedTime") == null;
final Map<Boolean, List<LdapAttributes>> parts = stream.collect(Collectors.partitioningBy(isEnabled));
final List<LdapAttributes> enabledAccounts = parts.get(true);
final List<LdapAttributes> disabledAccounts = parts.get(false);
logger.info("enabled accounts: " + enabledAccounts.size());
logger.info("disabled accounts: " + disabledAccounts.size());