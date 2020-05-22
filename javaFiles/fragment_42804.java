navigator.callslog.show = function () { cordova.exec (successcb, failcb, "callslog", "show", []);};

function successcb(s){
console.log(s);//what you passed from Java code
}

function failcb(e){
console.log("Err cb");
}