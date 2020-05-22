window.$ = window.jQuery = {};
function foo() {
    return 'bar';
}

parse = (function () {
    //disable all global keys
    eval("var " + Object.keys(window).join(', '));

    return function (_) {
        return eval("(" + _ + ")");
    };
})();


var snippets = [
    "window",
    "location",
    "$",
    "jQuery",
    "location.href='http://www.example.com'",
    'local',
    "{foo:'bar'}",
    "foo()",
    "eval('window')",
    'function ref(){return window}()'
];
snippets.forEach(function (snippet) {
    var local = 'local value';
    var expression = "parse(" + JSON.stringify(snippet) + ")";
    try {
        console.log(expression + " => " + JSON.stringify(parse(snippet)));
    } catch (e) {
        console.error(expression + " failed!");
    }
});