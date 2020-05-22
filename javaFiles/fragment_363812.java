<script>
$(document).ready(function() {
$('.decision').click(function(e) {
$.ajax({

type : 'POST',
dataType : 'json',
url : '/RealEstate/ChangeStatus.html',
data : ({

pid :$(this).siblings('.pid').val()
}),
success : function(response) {
alert(response);
$(this).html(response);
^------^ // here use this instead of .decision selector
/* $('.decision').text(response); */
},
error : function() {
alert('Error while request..');
}
});
});
});
</script>