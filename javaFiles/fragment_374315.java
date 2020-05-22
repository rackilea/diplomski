Obj1 : {
    id : int,
    name : string,
    Obj2 : {
     id : int,
     name : string
     obj1list : //ignored avoids recursion
    }
}

Obj2 : {
    id : int,
    name : string,
    obj1list : [{
     id : int,
     name : string,
     obj2 : //ignored avoids recursion
    },
    {
     id : int,
     name : string
     obj2 : //ignored avoids recursion
    }
    ]
}