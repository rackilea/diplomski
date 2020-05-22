@helper.inputText(articleForm("headline"), '_label -> "Überschrift"
                                     , '_showConstraints -> false
                                     , '_showErrors -> true
                                     , 'class -> "form-control"
                                     , 'label -> "label"
                                     , 'placeholder -> "sprechenden Titel eingeben"
                                     , 'oninput -> "verify()"
                                     )

<script>
function verify() {
    if(document.getElementById("headline").value.length >= 5 &&
       document.getElementById("textline").value.length >= 20){
        //alert("show");
        document.getElementById("btnSave").style.display = "block";
    }else{
        //alert("hide");
        document.getElementById("btnSave").style.display = "none";
    }
}
document.getElementById("btnSave").style.display = "none";
</script>