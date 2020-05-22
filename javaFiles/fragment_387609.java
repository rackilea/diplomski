...
$j.ajax({
    url : '../api/createDisplayGroup/postHtmlVar/' + containerID + '/' + containerType,
    data: JSON.stringify(json_data),
    dataType: 'json',
    type : 'post',
    contentType: 'application/json'
...