function checkedRadioForDelete(f) {
    var chx = document.getElementsByTagName('input');
    for ( var i = 0; i < chx.length; i++) {
        if (chx[i].type == 'radio' && chx[i].checked) {
            var con = confirm("<s:text name="msg.confirm"/>");
            if (con != true) {
            } else {
               f.action = "MyAction.action";
               f.submit();
             }
            return true;
         }
    }
    alert("<s:text name="msg.alert"/>");
    return false;
 }