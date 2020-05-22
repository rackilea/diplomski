interface IGpsService {
    Bundle getNavigationMessage();
    void resetStatistics();
    void recordingEnable(boolean recordingEnabled, boolean continueLastTrack);
    void registerCallback(IGpsChanged cb);
    void unregisterCallback(IGpsChanged cb);
    boolean isRecordingEnabled();
    void setGhost(int trackId);
    void startGhost();
    void sendUserEvent(int eventId);
}