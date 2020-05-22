angular.module('app.services', ['ngResource'])

.controller('MyController', function(User) {

    // Query userID 123, change the firstname and lastname then save.
    var user = User.get({userId:123}, function() {
      user.firstname = "joe";
      user.lastname = "bloggs";
      user.$save();
    }

   // Create a new user like this.
   var anotherUser = new User({
     username: 'joe.bloggs',
     email: 'joe.bloggs@example.com',
     firstname: 'joe',
     lastname: 'bloggs'
   });

   anotheruser.$save();
 })    

.factory('User', function($resource) 
 {       
    // Represent the user resource.
    return $resource('/myurl/create/:userId', {userId:'@id'});    

 });