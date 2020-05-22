function hash() {

    var h=0, i=0;

    if(hash.arguments.length == 1) {
        for(i=0; i<hash.arguments[0].length; i++) {
            h = (h * 31 + hash.arguments[0].charCodeAt(i)) & 0xffffffff;
        }
    }
    else {
        for(i in hash.arguments) {
            h ^= hash(hash.arguments[i]);
        }
    }

    return h;
}