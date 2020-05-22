let xx = &mut current_x[e..e3];
xx.copy_from_slice(&prev_y[0..e2]);

let yy = &current_y[e..e3];
for i in 0..(e3-e) {
    xx[i] += yy[i];
}