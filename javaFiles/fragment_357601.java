Template.articles.helpers({
  results : function() {
    if (Session.get("MyUsers")) {
      console.log(JSON.parse(Session.get("MyUsers")).results);
      return JSON.parse(Session.get("MyUsers")).results;
    };
  }
});