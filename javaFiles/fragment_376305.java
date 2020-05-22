function hex(length, n) {
 n = n.toString(16);
 return (n.length===length)? n : "00000000".substring(n.length, length) + n;
}

var idToParse = {
            "timestamp": 1491806328,
            "machineIdentifier": 9737042,
            "processIdentifier": 6393,
            "counter": 1399563,
            "date": 1491806328000,
            "time": 1491806328000,
            "timeSecond": 1491806328
        };


var idString = hex(8,idToParse.timestamp)+hex(6,idToParse.machineIdentifier)+hex(4,idToParse.processIdentifier)+hex(6,idToParse.counter);