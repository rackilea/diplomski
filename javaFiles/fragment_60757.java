$(document).ready(function () {
            $('#USA').change(function (event) {
                var id = $("#USA").val();
                $.get('PopulateCustomersTable', {
                    idcontry: id
                }, function (response) {
                    var select = $('#ddStates');
                    select.find('option').remove();
                    $.each(response, function (index, value) {
                        $('<option>').val(value.IdState).text(value.Description).appendTo(select);
                    });
                });
            });
            $('#NIC').change(function (event) {
                var id = $("#NIC").val();
                $.get('PopulateCustomersTable', {
                    idcontry: id
                }, function (response) {
                    var select = $('#ddStates');
                    select.find('option').remove();
                    $.each(response, function (index, value) {
                        $('<option>').val(value.IdState).text(value.Description).appendTo(select);
                    });
                });
            });
        });