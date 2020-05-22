@Override
public float score(Request request, Response response) {
    float result = super.score(request, response);

    if (isTokenedServerResource()) {
        boolean containsToken = containsToken(request);
        if (containsToken) {
            return result + 0.1f;
        } else {
            return result - 0.1f;
        }
    }

    return result;
}