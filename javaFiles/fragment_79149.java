Vector movementVector=...; // choose whatever class you want
Vector pointingVector=...;

if (movementVector.x == -pointingVector.x || movementVector.y == -pointingVector.y) {
    // if pressing W then decelerate
    // if reaching speed == 0 then change movementVector value and accelerate in the other way
}