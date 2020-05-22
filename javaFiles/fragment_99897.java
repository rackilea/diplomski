final private OSClient os;

public ObjectStorageDAO(String url, String userId, String password, String project, String domainName)
        throws Exception {

    Identifier domainIdentifier = Identifier.byName(domainName);
    Identifier projectIdentifier = Identifier.byName(project);

    os = OSFactory.builderV3().endpoint(url).credentials(userId, password)
            .scopeToProject(projectIdentifier, domainIdentifier).authenticate();

    /////////////////////////
    // force london region //
    /////////////////////////

    os.useRegion('london')
}

/**
 * Returns the list of containers under the account
 */
public List containers() {
    return os.objectStorage().containers().list();
}