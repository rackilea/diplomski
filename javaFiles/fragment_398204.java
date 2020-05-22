int left_edge  = pos_x;
    int right_edge = pox_x + width;
    if (velocity_x < 0)
        pos_x += left_edge > 0 ? velocity_x : 0;
    else if (velocity_x > 0)
        pos_x += right_edge < container_width ? velocity_x : 0;