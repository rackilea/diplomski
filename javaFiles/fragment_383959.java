row[i].onclick = (function (index) { //capture more aguments as passed
    return function () {
        alert(index);
        //more code
    }
}(i)); //pass in more arguments as needed