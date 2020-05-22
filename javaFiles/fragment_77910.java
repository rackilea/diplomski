$("#item1").change(function() {
    var value = $(this).val();
    $("#item2").html(options[value]);
});

$("#item2").change(function() {
    var value = $(this).val();
    $("#item3").html(options[value]);
});


var options = [
    "<option value='0'>item1: test 1</option><option value='1'>item1: test 2</option>",
    "<option value='0'>item2: test 1</option><option value='1'>item2: test 2</option>",
    "<option value='0'>item3: test 1</option><option value='1'>item3: test 2</option>"
];