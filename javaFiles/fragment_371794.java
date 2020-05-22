class Base
{
public:
  foo frobnicate(some arguments);
private:
  virtual foo do_frobnicate(some arguments) = 0;
};

foo Base::frobnicate(some arguments)
{
  check_precondition(arguments);
  foo result = do_frobnicate(arguments);
  check_post_condition(foo);
  return foo;
}