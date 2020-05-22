function drawTable(id, size, cb) {
  var $table = $('#' + id);
  var $tr = $('<tr>').appendTo($table);
  $('<th>').text(id).appendTo($tr);
  for (var c = 0; c < size; c++) {
    $('<th>').text(c).appendTo($tr);
  }
  for (var r = 0; r < size; r++) {
    var $tr = $('<tr>').appendTo($table);
    $('<th>').text(r).appendTo($tr);
    for (var c = 0; c < size; c++) {
      var n = cb(r, c, size);
      var $td = $('<td>').text(n).attr('data-d', n).appendTo($tr);
    }
  }
}

var size = 8
drawTable('id1', size, function(r, c, size) { return r - c + size; });
drawTable('id2', size, function(r, c, size) { return 2 * size - r - c - 1; });