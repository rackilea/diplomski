// specific file
grant codeBase "file:/test/path/tools.jar" {
  // no permissions for this one
};

// default to giving all
grant {
  permission java.security.AllPermission;
};