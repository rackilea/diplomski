function loadEvents() {
  var events = getJSON("/api/events", function(err, events) {
    if (err) throw Error(err); // error handle here
    // logic here
    var len = events.length;
  });
}

var getJSON = function(url, callback) {
  var xhr = new XMLHttpRequest();
  xhr.open('GET', url, true);
  xhr.responseType = 'json';
  xhr.onload = function() {
    var status = xhr.status;
    if (status === 200) {
        callback(null, xhr.response);
    } else {
        callback(status, xhr.response);
    }
  };
  xhr.send();
};