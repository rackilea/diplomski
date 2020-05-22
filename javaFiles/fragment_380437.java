//sample data object

      var vertical = {
        a: 10,
        b: 20,
        c: 40
      };
      var data = Object.keys(vertical);

      total = 0;
      var c = document.getElementById("myCanvas");
      var ctx = c.getContext("2d");
      ctx.fillStyle = "blue";
      for (var i = 0; i < data.length; i++) {

        total = total + vertical[data[i]];

      }

      color = ['red', 'blue', 'yellow'];
      start = 0;

      for (var i = 0; i < data.length; i++) {

        ctx.fillRect((i * 60) + 50, 100, 10, -(vertical[data[i]]));
        ctx.font = "9px Arial";
        ctx.fillText(data[i], (i * 60) + 51, 112);
        ctx.fillText((20 * i), 30, ((20 * -i) + 100));

        ctx.beginPath();
        ctx.moveTo(600, 150);
        ctx.arc(600, 150, 150, start, start +
          (Math.PI * 2 * (vertical[data[i]] / total)), false);
        ctx.lineTo(600, 150);
        ctx.fillStyle = color[i];
        ctx.fill();
        start += Math.PI * 2 * (vertical[data[i]] / total);
      }