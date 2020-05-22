public ReturnCode Intersection (Circle circle, Rectangle rectangle) {

... // test something
... return ReturnCode.CODE1;
... // test another thing
... return ReturnCode.CODE2;
... 
... return (xCornerDistSq + yCornerDistSq <= maxCornerDistSq) ? ReturnCode.CODE3 : ReturnCode.CODE4;
}