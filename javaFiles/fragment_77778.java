A obj = null;
switch (var){
        case "YES" : {
              obj = new B();
              break;
       }
        case "NO": {
              obj = new C();
       }
        default: {
              obj = new B();
       }

     }
NewObject newObject = obj.objToNewObject(param);