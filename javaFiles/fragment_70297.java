Handle<mirror::Object> object(hs.NewHandle(result.GetL()));
if (UNLIKELY(object.IsNull())) {
  // This will typically be for LambdaMetafactory which is not supported.
  ThrowClassCastException("Bootstrap method returned null");
  return nullptr;
}