// Create ARCore session that supports Augmented Faces
public Session createAugmentedFacesSession(Activity activity) throws 
                                                      UnavailableException {

    // Use selfie camera
    Session session = new Session(activity, 
                                  EnumSet.of(Session.Feature.FRONT_CAMERA));

    // Enabling Augmented Faces
    Config config = session.getConfig();
    config.setAugmentedFaceMode(Config.AugmentedFaceMode.MESH3D);
    session.configure(config);
    return session;
}