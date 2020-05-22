import com.jayway.jsonpath.JsonPath;

String author0 = JsonPath.read(document, "$.store.book[0].author");
Failure = !"John Smith".equals(author0);
if (Failure) {
  FailureMessage = "Expected John Smith as author";
}