@Override
public void setProfile(TOProfile profile) {
    CouchDbClient dbClient = Utilities.dbConnect();
    profile.set_rev(dbClient.update(profile).getRev());
    this.profile = profile;
}