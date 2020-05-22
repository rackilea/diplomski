Storage.Objects.Get get = storage.objects().get(BUCKET_NAME_APP_DATA, fileName);
HttpResponse httpResponse = get.executeMedia();
String x_goog_hash = httpResponse.getHeaders().get("x-goog-hash").toString().replaceAll("\\s+","");
if (TextUtils.isEmpty(x_goog_hash))
    throw new IOException("Response x-goog-hash was null");

final int start = x_goog_hash.indexOf("md5=");
final int end = x_goog_hash.indexOf("==", start);

if (start == -1 || end == -1 || end <= start)
    throw new IOException("Response x-goog-hash of unexpected type " + x_goog_hash);

serverHash = x_goog_hash.substring(start + 4, end + 2);
if (TextUtils.isEmpty(serverHash))
    throw new IOException("Response md5 was null");

Log.i("Ayush", "Md5 hash = ? " + serverHash);
bufferedInputStream = new BufferedInputStream(httpResponse.getContent());