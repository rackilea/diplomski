$("#addRow").click(function(){
                    //alert("The button was clicked.");
                    var addressRow = $('.repeat-address').last();
                    var addressRowLength = $('.repeat-address').length;

                    var newAddressRow = addressRow.clone(true).find("input").val("").end(); 

                    $(newAddressRow).find("td input,td select").each(function(index,item) {
                        item.name = item.name.replace(/[0-9]/g,addressRowLength);
                    });

                    newAddressRow.insertAfter(addressRow);


                });