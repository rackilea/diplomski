import java.util.stream.IntStream;

JSONArray shots = response.getJSONArray("shots");
String titles[] = IntStream
    .range(0, shots.length())
    .mapToObj(i -> shots.getJSONObject(i))
    .map(post -> post.getString("title"))
    .toArray(String[]::new);
}