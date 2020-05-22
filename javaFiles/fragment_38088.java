function setIntervalXTimes(callback, delay, repetitions,actualResult) {
        var x = 0;
        var intervalID = setInterval(function() {
          callback();
          if (++x === repetitions) {
            clearInterval(intervalID);
            $("#dice-result").text(actualResult); // and here set the number
          }
         }, delay);
   }