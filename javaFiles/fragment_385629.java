Object.prototype.getNestedValue = function(...a) {
  return a.length > 1 ? (this[a[0]] !== void 0 && this[a[0]].getNestedValue(...a.slice(1))) : this[a[0]];
};
Object.prototype.setNestedValue = function(...a) {
  return a.length > 2 ? typeof this[a[0]] === "object" && this[a[0]] !== null ? this[a[0]].setNestedValue(...a.slice(1))
                                                                              : (this[a[0]] = typeof a[1] === "string" ? {} : new Array(a[1]),
                                                                                 this[a[0]].setNestedValue(...a.slice(1)))
                      : this[a[0]] = a[1];
};

var data = "A-->B-->C-->D-->E\nA-->B-->C-->D-->F\nA-->F-->C-->D-->E",
  datarr = data.split("\n").map(e => e.split("-->")), // get your list in an array
       o = {};
datarr.forEach(a => !o.getNestedValue(...a) && o.setNestedValue(...a,null));

console.log(JSON.stringify(o,null,2));