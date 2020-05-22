$("#buttonPieGenerate").live("click", function(){

    $.ajax({
        url: "drawPieChart", //method from controller
        contentType: "application/json",
        data: params,
        success: function(data) {

        drawPieChart(data.percentages, data.topics,'chart_div',600,400);
        }
    });

});