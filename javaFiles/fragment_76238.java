//in facebookandroid.h
class FacebookAndroid {
    public:
    FacebookAndroid* instance();
    void handleNewNotification(QString notification);

    protected:
    static FacebookAndroid *s_instance;
};

//in facebookandroid.cpp
FacebookAndroid* FacebookAndroid::s_instance = 0;

FacebookAndroid::FacebookAndroid(QObject *parent) : QObject(parent) {
    s_instance = this; // remind your first instanciation here
}

FacebookAndroid* FacebookAndroid::instance() {
    return s_instance;
}