"fnServerData": function ( sSource, aoData, fnCallback ) {
                    aoData.push( { "name" : "myTeamId", "value" : myTeamId  } );
                    $.getJSON( sSource, aoData, function (json) { 
                        fnCallback(json);
                    });
              }