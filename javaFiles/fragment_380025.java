$.ajax({
        type: "POST",
        url: "MatchingServlet?method=methodA",
        data: matchingData_X,
  success: function(data) {
     $('.input_A).html(data);
     }
});