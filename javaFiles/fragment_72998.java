<script language=javascript">
  function callOnsubmit(form) {
    var code = form.getAttribute("onsubmit");
    eval(code);
</script>

<s:textfield name="foo" onblur="callOnsubmit(this.form);"/>