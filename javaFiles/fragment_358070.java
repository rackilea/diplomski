db.test.drop()
db.test.insert([
{ "a" : "Boxer One" },
{ "a" : "A boxer dog" },
{ "a" : "A box shouldn't match" },
{ "a" : "should match BOXER" },
{ "a" : "wont match as this it the plural BOXERs" },
{ "a" : "also match on cat" }])