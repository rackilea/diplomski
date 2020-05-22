gapi.client.load('oauth2', 'v2', function() {
  gapi.client.oauth2.userinfo.get().execute(function(resp) {
    // Shows user email
    console.log(resp.email);
  })
});

gapi.client.load('plus', 'v1', function() {
  gapi.client.plus.people.get( {'userId' : 'me'} ).execute(function(resp) {
    // Shows other profile information
    console.log(resp);
  })
});