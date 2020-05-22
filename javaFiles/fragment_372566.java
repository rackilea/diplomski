highlighter: {
                                tooltipContentEditor: function(current, serie, index, plot){
                                    var val = plot.data[serie][index];
                                    var valArr = val[0].split(" ");
                                    return valArr[1] + ', ' + val[1];
                                }
                            }