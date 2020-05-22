$("#deleteBuildingConfirm").click(function(q){
                       $('#confirmDelete').modal('hide');

                       $.ajax({
                        type : 'POST',
                        url : '@routes.Admin.deleteBuilding()',
                        data : {
                            id: idOfBuild, name: nameOfBuild
                        },
                        success : function(data) {

                            alert(data);
                         /** Wenn ein gebäude.. */

                        },
                         error : function(err) {
                            // use err.responseText instead of err
                            alert(err.responseText);            
                            }

                        });

                            return true;
                });