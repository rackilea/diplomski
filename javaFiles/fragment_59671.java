class Class1 {
private:
     std::vector<MyEventListener*> listeners;

public:
    void doEvent () {
        for(MyEventListener* e : listeners) {e->eventHappened(args);
    }
    void addToListeners(MyEventListener* eventListener){
        listeners.push_back(eventListener);
    }
    void removeFromListeners(MyEventListener* eventListener){
        listeners.push_back(eventListener);  // same bug as in your java version :P
    class MyEventListener {
        virtual void eventHappend (Anything passable) = 0;
        virtual ~MyEventListener(){}
    }; 
};