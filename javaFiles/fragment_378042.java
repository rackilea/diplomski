function validate(form) {
  var fnMap = {

    'validate-dateISO8601': {
      checkFn: isValidISO8601,
      checkMsg: 'Date must be in format yyyy-mm-dd'
    },

    'validate-dateValid': {
      checkFn: isValidDate,
      checkMsg: 'Date must be a valid date'
    }
  };

  var reClass = /(^|\s*)validate-[^\s]*/g;
  var control, controls = form.elements;
  var check, checks;
  var fn, value;

  for (var i=0, iLen=controls.length; i<iLen; i++) {
    control = controls[i];

    // Need a function here to handle more control types
    value = control.value;
    checks = control.className.match(reClass);

    // If there are any validate- classes
    if (checks) {

      // For each validate class
      for (var j=0, jLen=checks.length; j<jLen; j++) {
        check = checks[j].replace(/\s/g,'');

        // See if there is a related function
        if (fnMap.hasOwnProperty(check)) {
          check = fnMap[check];

          // If there is, run it
          // If it fails, show the message
          // This part could be collected in an array and all the
          // error messages desplayed at once or in suitable message
          // elements in the document. But alert is cheap :-)
          if (!check.checkFn(value)) {
            alert(check.checkMsg);
            control.focus();
            return false;
          }
        }
      }
    }
  }
}

// Just checks the pattern is yyyy/mm/dd
function isValidISO8601(s) {
    s.replace(/^\s+|\s+$/g, '');
    return /\d{4}[-\/]\d{2}[-\/]\d{2}/.test(s);
} 

// Checks that s is a valid date
function isValidDate(s) {
    var bits = s.split(/[-\/]/g);
    var d = new Date(bits[0], bits[1] - 1, bits[2]);
    return d.getFullYear() == bits[0] && d.getDate() == bits[2];
}

</script>