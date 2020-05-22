Array.prototype.indexOf = Array.prototype.indexOf || function( search ) {
    for(var i = 0, len = this.length; i < len; i++) {
        if( this[ i ] === search ) {
            return i;
        }
    }
    return -1;
};