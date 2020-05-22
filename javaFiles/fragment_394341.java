$(document).ready(function () {
$("td", this).on("click", function () {
    var tds = $(this).parents("tr").find("td");
    $.each(tds, function (i, v) {
        $($(".data-form input")[i]).val($(v).text());
    });
});
});