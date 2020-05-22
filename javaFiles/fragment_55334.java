public class CachedCallAdapterFactory extends CallAdapter.Factory {

final Executor callbackExecutor;

public CachedCallAdapterFactory(Executor callbackExecutor) {
    this.callbackExecutor = callbackExecutor;
}

@Override
public CallAdapter<Call<?>> get(final Type returnType, final Annotation[] annotations, final Retrofit retrofit) {
    if (getRawType(returnType) != CachedCall.class) {
        return null;
    }
    final Type responseType = getParameterUpperBound(0, (ParameterizedType) returnType);
    return new CallAdapter<Call<?>>() {
        @Override public Type responseType() {
            return responseType;
        }

        @Override public <R> Call<R> adapt(Call<R> call) {
            return new CachedCall<>(callbackExecutor, call, responseType, retrofit, annotations);
        }
    };
}