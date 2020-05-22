$(function() {
    $("#categorySubmit").button().click(function(event) {
        $(function() {
            $("#selectable li:not(.ui-selected)", this).each(function() {
                $(this).empty();
            });
        });
    });
});