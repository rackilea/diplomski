..
public Object decode(Response response, Type type) throws IOException {
    if(response.status() == 404) {
        return Util.emptyValueOf(type);
    }
..