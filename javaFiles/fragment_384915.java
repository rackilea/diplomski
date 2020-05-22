function divideIntoFiveSegments(startPoint, endPoint) {
    let {x: x1, y: y1} = startPoint;
    let {x: x2, y: y2} = endPoint;

    let dx = (x2 - x1) / 5; 
    let dy = (y2 - y1) / 5;

    let interiorPoints = [];

    for (let i = 1; i < 5; i++)
        interiorPoints.push({x: x1 + i*dx, y: y1 + i*dy});

    return [startPoint, ...interiorPoints, endPoint];
}