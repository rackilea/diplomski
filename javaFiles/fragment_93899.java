$mydropdown.change(function(){
   nicEditors.findEditor("TextArea").setContent(nicEditors.findEditor("TextArea").getContent() + TextVars[$(this).val()]);
}); 

$("input[type='checkbox'][name*='ImageVar']").change(function(){
   var $chk = $(this);
   if($chk.prop('checked')){
      nicEditors.findEditor("TextArea").setContent(nicEditors.findEditor("TextArea").getContent() + ImageVars[$chk.attr('name')]);
   }else{
      nicEditors.findEditor("TextArea").setContent(nicEditors.findEditor("TextArea").getContent().replace(ImageVars[$chk.attr('name')], ""));
   }
});