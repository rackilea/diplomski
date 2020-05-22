Template.search.events({
  'submit form':function (event){
    event.preventDefault();
    var FormParamX = event.target.FormParamX.value;
    var FormParamY = event.target.FormParamY.value;

    Meteor.call("getusershttp",FormParamX,FormParamY,function(error, results) {
      Session.set("MyUsers",results.content);
    });
  }
});