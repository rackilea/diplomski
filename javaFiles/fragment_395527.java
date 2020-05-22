$.ajax({
url:"/ChargeData",
type: “POST”,
dataType: “json”,
data: data,
success: function(result) {
console.log(result.jqgrid_data);    
setRequestList(result.jqgrid_data)
}
})