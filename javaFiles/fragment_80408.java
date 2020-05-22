Array.prototype.remove = function(o) {
    var index = this.indexOf(o);
    if(~index) {
        this.splice(index, 1);
    }
};