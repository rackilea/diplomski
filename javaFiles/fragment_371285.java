"use strict";

// This series of points represents the "height" values of the landscape.
var points = [10, 50, 150, 20, 100, 10];

// Let's pick a random X position...
var x = Math.random() * (points.length-1);

// We can get the height at a given point by interpolating the vertices:
var v1 = points[Math.floor(x)];
var v2 = points[Math.ceil(x)];
var y = v1 + ((v2-v1) * (x % 1.0));

// Now let's draw the "game" state...
var canvas = document.getElementById("game_canvas");
var ctx = canvas.getContext("2d");
var x_scale = canvas.width / points.length;

// This is the "world"...
ctx.moveTo(0, points[0]);
for (var p = 1; p < points.length; ++p) { ctx.lineTo(x_scale * p, points[p]); }
ctx.stroke();

// ...and this is the "player".
ctx.fillStyle = "red";  
ctx.fillRect((x * x_scale)-4, y-4, 8, 8);