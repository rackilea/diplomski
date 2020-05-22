Observable<DeviceCredential> getCredentials() {
    return deviceCredentialService()
      .getCredentials()
      // Only get creds from network
      .filter(e -> e.getFrom() == SyncedDataSourceObservableFactory.From.SOURCE)
      .flatMapIterable(e -> e.getData());
  }

  Single<Organization> getOrgFromCreds(String orgid) {
    return getCredentials()
      // A device is logically constrained to only have a single cred per org
      .map(DeviceCredential::getOrganization)
      .filter(org -> org.getId().equals(orgid))
      .singleOrError();
  }