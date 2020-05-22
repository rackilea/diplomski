//JAVASCRIPT or <script> tag

$("form").on("submit", function (event) {
   event.preventDefault();
   let filteredArray = $('#profile-form').serializeArray().filter(function (k) {
      return $.trim(k.value);
   });
   console.log(filteredArray);
});