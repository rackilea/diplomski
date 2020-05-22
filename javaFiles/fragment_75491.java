<script>
//script at the bottom of the body to change select dropdown based on currently selected mainheading value.
//old method tried to use scriptlets mixed with javascript, but it's easier to do this with javascript.
const urlParams = new URLSearchParams(window.location.search);
const myParam = urlParams.get('mainHeading'); 
//if mainHeading parameter is null or equal to GÉANT Operations show GÉANT Operations dropdown
if(myParam === 'GÉANT Operations' || myParam === null) {
    document.getElementById('mainHeading').value = 'GÉANT Operations';
}else{
    document.getElementById('mainHeading').value = 'GÉANT Future Plans';
}
</script>