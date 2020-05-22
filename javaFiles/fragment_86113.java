"use strict";
(function() {
  try {
    console.log(JSON.parse('{"{\\"type\\":\\"HUMAN\\"}":"1.0"}'));
  } catch (e) {
    console.error(e);
  }
}());