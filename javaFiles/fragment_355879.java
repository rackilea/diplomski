function docWriteWrapper(func) {
    var writeTo = document.createElement('del'),
        oldwrite = document.write,
        content = '';
    writeTo.id = "me";
    document.write = function(text) {
        content += text;
    }
    func();
    writeTo.innerHTML += content;
    document.write = oldwrite;
    document.body.appendChild(writeTo);
}