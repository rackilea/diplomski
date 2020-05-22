if(angle < touchAngle) {
    if(abs(angle - touchAngle)<180)
       angle += 1;
    else angle -= 1;
}

else {
    if(abs(angle - touchAngle)<180)
       angle -= 1;
    else angle += 1;
}