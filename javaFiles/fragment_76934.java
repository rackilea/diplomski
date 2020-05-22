$(".btn").click(function(event) {
         event.preventDefault();

         var currentProjectId= $('#currentProjectId').val();
         var userId = $(this).attr("name");

        addUser(currentProjectId, userId);

    });