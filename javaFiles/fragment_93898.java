$mydropdown.change(function(){
   nicEditors.findEditor("TextArea").setContent($mytextbox.val() + TextVars[$(this).val()]);
}); 

$("input[type='checkbox'][name*='ImageVar']").change(function () {
  var $chk = $(this);
  if ($chk.prop('checked')) {
    nicEditors.findEditor("TextArea").setContent($mytextbox.val() + ImageVars[$chk.attr('name')]);
  } else {
    nicEditors.findEditor("TextArea").setContent($mytextbox.val().replace(ImageVars[$chk.attr('name')], ""));
  }
});