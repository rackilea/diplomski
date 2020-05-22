function getISOOffset(date) {
  date = date || new Date();
  function z(n){return ('0'+n).slice(-2)}
  var offset = date.getTimezoneOffset();

  // ECMScript offset sign is the reverse of ISO 8601
  var sign = offset < 0? '+' : '-';
  offset = Math.abs(offset);
  return sign + z(offset/60 | 0) + ':' + z(offset % 60);
}

console.log('The host offset is UTC' + getISOOffset())