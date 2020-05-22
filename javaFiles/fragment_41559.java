int result = 0;
if have_stock{
    result = max(prices[current_day] - fee + f(current_day + 1, no_stock), f(current_day + 1, have_stock));
}else{
    result = max(-price[current_day] + f(current_day + 1, have_stock) , f(current_day + 1, no_stock));
}