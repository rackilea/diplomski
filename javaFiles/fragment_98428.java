//Singleton template definition
template <typename TDerived>
class Singleton {
  static_assert(is_base_of<Singleton, TDerived>::value, "Singleton: unexpected Derived template parameter");
  public:
    static TDerived& instance() {
      static TDerived instance_;
      return instance_;
    }

  protected:
  Singleton() {
  }
};

// SomeSingleton definition, using the Singleton template
class SomeSingleton : public Singleton<SomeSingleton> {
  ...
};