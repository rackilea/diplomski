Meteor.methods({
  "createNewCustomer" : function(options) {
    var ret = JSON.parse(options);             
    Customers.insert(ret);
  }
});