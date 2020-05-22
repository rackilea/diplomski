class Observer {
public:
  virtual void frobination() = 0;
  virtual ~Observer() {}
};

inline void bar(Observer *o) {
  o->frobination();
}