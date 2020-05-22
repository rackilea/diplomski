FB.login(function(response) {
   if (response.authResponse) {
     FB.api('/me/feed', 'post', {message: 'I signed up for the service X!'});
     });
   } else {
     console.log('User cancelled login or did not fully authorize.');
   }
 }, {scope: 'publish_actions'});