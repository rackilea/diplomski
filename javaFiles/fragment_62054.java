.workareacontainer {
    min-height: 400px;
    height: 100%;

    /* 
    Add a minimun width to the "workareacontainer" container div, 
    the browser will use this value when the resize event takes in
    for the minimun width calculation (as it does for the height) 
    */
    min-width: 800px;
}

.workareacontainer > div {
    height: 100%;

    /* 
    Add extra padding to the right
    so the green div shows contained inside this
    */
    padding: 5px;        
    padding-right: 30px;

    /* 
    Replace this line 
       width: 800px;
    with: 
    */
       width: 90%; 
    /* 
    Here you make the workarea adaptable to the browser's width size, 
    leaving a small gap of 5% at both margins that will make your 
    workarea look "centered" 
    */

    min-width: 800px;
    margin: 0 auto;
    background-color: red;
}

.workareacontainer > div > div {
    /* 
    Remove the absolute positioning, add extra padding to the right
    so the TabSheet shows contained inside the div
    */
      padding: 5px;
    padding-right: 20px;

    height:100%;
    width:100%;

    background-color: green;
}