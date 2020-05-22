// Verify key
Akismet api = new Akismet("key", "http://url.com", "Test/1.0");
if (!api.VerifyKey()) throw new Exception("Key could not be verified.");

// Create comment object for testing
AkismetComment comment = new AkismetComment();
comment.Blog = "http://joel.net";
comment.UserIp = "147.202.45.202";
comment.UserAgent = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)";
comment.CommentContent = "<a href=\"http://someone.finderinn.com\">find someone</a>";
comment.CommentType = "comment";
comment.CommentAuthor = "someone";
comment.CommentAuthorEmail = "backthismailtojerry@fastmail.fm";
comment.CommentAuthorUrl = "http://someone.finderrin.com";

// Test comment against akismet's service
bool isSpam = api.COmmentCheck(comment);