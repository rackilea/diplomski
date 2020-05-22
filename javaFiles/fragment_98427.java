class SomeSingleton {
  public:
    static SomeSingleton& instance() {
      static SomeSingleton instance_;
      return instance_;
    }

  private:
  SomeSingleton() {
    ...
  }
};