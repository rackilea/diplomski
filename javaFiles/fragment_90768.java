const depth = 1500;
      deg = pi / 180;

      { some vertices for a dice :) }
      vertices:array[0..23] of real= (50, 50, 50,       { 0}
                                 -50, 50, 50,       { 1}
                                  50,-50, 50,       { 2}
                                 -50,-50, 50,       { 3}
                                  50, 50,-50,       { 4}
                                 -50, 50,-50,       { 5}
                                  50,-50,-50,       { 6}
                                 -50,-50,-50,       { 7}
                                  );

{ transform 3d coordinates to pixel coordinates }
procedure 3d_to_2d(x, y, z : real; var px, py : longint);
 var k:real;
begin
 k:=((depth shr 1)+z)/depth;
 px:=(getmaxx shr 1)+trunc(x*k);      { getmaxx is the width of the screen }
 py:=(getmaxy shr 1)+trunc(y*k);      { getmaxy is the height of the screen }
end;

{ rotate around the x axis by rx degrees }
procedure xrot(var x,y,z:real;rx:integer);
 var x1,y1,z1:real;
begin
 y1:=(y * cos(rx * deg))+(z* (sin(rx * deg)));
 z1:=(-y* sin(rx * deg))+(z* (cos(rx * deg)));
 y:=y1; z:=z1;
end;

{ rotate around the y axis by ry degrees }
procedure yrot(var x,y,z:real;ry:integer);
 var x1,y1,z1:real;
begin
 x1:=(x * cos(ry * deg))+(z*(sin(ry * deg)));
 z1:=(-x * sin(ry * deg))+(z*(cos(ry * deg)));
 x:=x1; z:=z1;
end;

{ rotate around the z axis by rz degrees }
procedure zrot(var x,y,z:real; rz:integer);
 var x1,y1,z1:real;
begin
 x1:=(x* cos(rz * deg))+(y*(sin(rz * deg)));
 y1:=(-x* sin(rz * deg))+(y*(cos(rz * deg)));
 x:=x1; y:=y1;
end;