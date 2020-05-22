schema   : {
    parse: function (d) {
        if (d.dataFile) {
            return d.dataFile;
        } else {
            return [ d ];
        }
    }
},