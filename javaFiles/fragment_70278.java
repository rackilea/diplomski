CodeMirror.fromTextArea(document.getElementById("TEXTAREA_ID"), {
  mode:  "text/x-java",
  indentWithTabs: true,
  smartIndent: true,
  lineNumbers: true,
  lineWrapping: true,
  matchBrackets : true,
  autofocus: true
});