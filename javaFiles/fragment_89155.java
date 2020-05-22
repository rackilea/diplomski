function submitForm() {

    var editor = ace.edit("editor");
    var code = editor.getSession().getValue();
    document.getElementById('textArea').style.display = "block";
    document.getElementById('textArea').value=code;

    document.getElementById("divdata").submit();
}