final MessageWrapper received = (MessageWrapper) ois.readObject();
switch (received.getType())
{
  case FOO:
    return handleFoo((FooMessage) received);
  case BAR:
    return handleBar((BarMessage) received);
}