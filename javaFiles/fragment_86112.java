"use strict";
(function () {
  try {
    JSON.parse('{"{\"type\":\"HUMAN\"}":"1.0"}');
  } catch (e) {
    console.error(e);
  }
}());