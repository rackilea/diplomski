public class Helper {
    ...
    void newMagazineIssued() {
        mSubscriber.onActionDone();
    }

    void newMagazineFailed() {
        mSubscriber.onActionFailed();
    }
    ...
}