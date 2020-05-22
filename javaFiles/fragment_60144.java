UserPrincipal authenticatedUsers = path.getFileSystem().getUserPrincipalLookupService()
        .lookupPrincipalByName("Authenticated Users");
AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);

// Create ACL to give "Authenticated Users" "modify" access
AclEntry entry = AclEntry.newBuilder()
        .setType(AclEntryType.ALLOW)
        .setPrincipal(authenticatedUsers)
        .setFlags(DIRECTORY_INHERIT,
                  FILE_INHERIT)
        .setPermissions(WRITE_NAMED_ATTRS,
                        WRITE_ATTRIBUTES,
                        DELETE,
                        WRITE_DATA,
                        READ_ACL,
                        APPEND_DATA,
                        READ_ATTRIBUTES,
                        READ_DATA,
                        EXECUTE,
                        SYNCHRONIZE,
                        READ_NAMED_ATTRS)
        .build();