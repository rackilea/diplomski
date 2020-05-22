class Object;
class GlobalMediator;
class Mediator;

class IMediator
{
public: 
    virtual void Send(QString from , QString to, QString message) = 0;
    virtual void Send(QString from , QString to, QString parametr , QString message) = 0;
    virtual void Send(QString from , QString to , QGraphicsItem *item) = 0;
    virtual void Send(QString from , QString to , QString message , QVector<QString> vect) = 0;

//    virtual void SendFromOut(QString from , QString to, QString message) = 0;
};

class Mediator :  public QObject , public IMediator
{
    Q_OBJECT
private:
    QMap<QString ,Object* > map;
    GlobalMediator *gMed;
    QString name;

public:
    Mediator(QString name);
    QString getName();
    void Register(Object* obj);
    void Unregister(QString name );
    void setGlobalMediator(GlobalMediator *gm);

    void Send(QString from , QString to,  QString message);
    void Send(QString from , QString to, QString parametr , QString message);
    void Send(QString from , QString to , QGraphicsItem *item);
    void Send(QString from , QString to , QString message , QVector<QString> vect);



};

class GlobalMediator
{
private:
    QMap<QString , Mediator*> map;
public:
    GlobalMediator();
    void RegisterMediator(Mediator *med);
    void UnregisterMediator(Mediator *med);
\

};



class Object
{
//    Q_OBJECT


public:
    Object(Mediator *medium , QString name);
    Object(QString name);

private:
    Mediator *medium;

protected:
    QString name;

public: //others
    void AddMediator(Mediator *med);
    Mediator* getMediator();
    QString _name();

public:
    virtual void Send(QString to , QString message);
    virtual void Send(QString to, QString parametr , QString message);
    virtual void Send(QString to, QGraphicsItem *item);
    virtual void Send(QString to , QString message , QVector<QString> vect);

    virtual void Receive(QString from, QString message);
    virtual void Receive(QString from, QString parametr , QString message);
    virtual void Receive(QString from, QGraphicsItem *item);
    virtual void Receive(QString from , QString message , QVector<QString> vect);

};

#endif // MEDIATOR_H