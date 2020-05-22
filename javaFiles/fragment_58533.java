@Override
public VfNetResponse<T> parseNetworkResponse(Response response, int id) throws Exception {
    Type dataType =  ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    Type type = new ParameterizedTypeImpl(new Type[]{dataType}, null, VfNetResponse.class);
    VfNetResponse<T> netResponse = JSON.parseObject(response.body().string(), type);
    return netResponse;
}