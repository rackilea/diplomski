jQuery(document).ready(function() {
  $("#selectEmp").on('change', function() {
    $dept = $("#dept");
    $(this).val() == '2' ? $dept.show() : $dept.hide();
  });
});