function calculate_original_selection(original_width, resized_width, selection_x_start, selection_y_start, selection_x_end, selection_y_end) {
    var ratio = original_width / resized_width;
    var selection_info = new Object();

    selection_info.x_start = Math.round(selection_x_start * ratio);
    selection_info.y_start = Math.round(selection_y_start * ratio);
    selection_info.x_end = Math.round(selection_x_end * ratio);
    selection_info.y_end = Math.round(selection_y_end * ratio);

    return selection_info;
}

//examples:
console.log(calculate_original_selection(5000, 1000, 250, 250, 750, 750));
console.log(calculate_original_selection(200, 100, 25, 25, 75, 75));
console.log(calculate_original_selection(250, 100, 10, 40, 20, 40));