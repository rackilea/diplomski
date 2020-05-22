a_x = Math.sin(theta)*a;
a_y = -Math.cos(theta)*a;
v_x_new = v_x_old + a_x*timeDiff;
v_y_new = v_y_old + a_y*timeDiff;
x_new = x_old + v_x_old*timeDiff + a_x*timeDiff*timeDiff/2;
y_new = y_old + v_y_old*timeDiff + a_y*timeDiff*timeDiff/2;

x_old = x_new;
y_old = y_new;
v_x_old = v_x_new;
v_y_old = v_y_new;