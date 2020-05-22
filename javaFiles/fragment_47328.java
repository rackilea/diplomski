<script>
function show(which) {
var hide = new Array();
hide = document.getElementsByName(which);
for (i=0; i<hide.length; i++) {
hide[i].style.display = 'inline';
}
}
function hide(which) {
var hide = new Array();
hide = document.getElementsByName(which);
for (i=0; i<hide.length; i++) {
hide[i].style.display = 'none';
}
}
</script>
<style type="text/css">
iframe { display: none; }
</style>
<b>Google</b>
<input type="button" value="Show" onclick="show('iframe');">
<input type="button" value="Hide" onclick="hide('iframe');">
<iframe src='http://www.google.com' width='100%' height='100%' scrolling='yes'       name='iframe'></iframe>