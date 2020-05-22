// JavaScript
function Foo() { }
function Bar() { }
var p = new Foo();
p.constructor == Foo; // => true
p.constructor = Bar;
p.constructor == Foo; // => false