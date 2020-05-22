btoa(
  "Subject: Example Subject\r\n" +
  "From: <example@gmail.com>\r\n" +
  "To: <example@gmail.com>\r\n" +
  "Content-Type: multipart/alternative; boundary=\"foo_bar\"\r\n\r\n" +

  "--foo_bar\r\n" +
  "Content-Type: text/plain; charset=UTF-8\r\n\r\n" +

  "*Bold example message text*\r\n\r\n" +

  "--foo_bar\r\n" +
  "Content-Type: text/html; charset=UTF-8\r\n\r\n" +

  "<div dir=\"ltr\"><b>Bold example message text</b></div>\r\n\r\n" +

  "--foo_bar--" 
).replace(/\+/g, '-').replace(/\//g, '_');

POST https://www.googleapis.com/gmail/v1/users/me/messages/send?access_token={YOUR_API_KEY}

{
 "raw": "U3ViamVjdDogRXhhbXBsZSBTdWJqZWN0DQpGcm9tOiA8ZXhhbXBsZUBnbWFpbC5jb20-DQpUbzogPGV4YW1wbGVAZ21haWwuY29tPg0KQ29udGVudC1UeXBlOiBtdWx0aXBhcnQvYWx0ZXJuYXRpdmU7IGJvdW5kYXJ5PSJmb29fYmFyIg0KDQotLWZvb19iYXINCkNvbnRlbnQtVHlwZTogdGV4dC9wbGFpbjsgY2hhcnNldD1VVEYtOA0KDQoqQm9sZCBleGFtcGxlIG1lc3NhZ2UgdGV4dCoNCg0KLS1mb29fYmFyDQpDb250ZW50LVR5cGU6IHRleHQvaHRtbDsgY2hhcnNldD1VVEYtOA0KDQo8ZGl2IGRpcj0ibHRyIj48Yj5Cb2xkIGV4YW1wbGUgbWVzc2FnZSB0ZXh0PC9iPjwvZGl2Pg0KDQotLWZvb19iYXItLQ=="
}