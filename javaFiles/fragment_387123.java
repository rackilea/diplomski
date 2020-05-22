import play.mvc.Http.MultipartFormData.*;

//the file you want to post
Source<ByteString, ?> file = FileIO.fromFile(new File("hello.txt"));

//generate the right format for posting
FilePart<Source<ByteString, ?>> fp = new FilePart<>("hello", "hello.txt", "text/plain", file);

DataPart dp = new DataPart("key", "value");// the data you want to post

ws.url(url).post(Source.from(Arrays.asList(fp, dp)));