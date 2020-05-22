db.collection.find({
        SubMenu: {
            $exists: true
        }
    }).forEach(function(myDoc) {
        var child = myDoc.SubMenu;
        for (var i = 0; i < child.length; i++) {
            var ob = child[i];
            if ('orderBy' in ob) {
                ob.orderBy = NumberInt(ob.orderBy);
                child[i] = ob;
            }

        }
        db.collection.update({
            _id: myDoc._id
        }, {
            $set: {
                subMenu: child
            }
        });
        printjson(myDoc);
    });