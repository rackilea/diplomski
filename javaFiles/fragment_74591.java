$('.invoice-link').click(function(e){
     e.preventDefault();
     var $link = $(this),  
         $form_modal = $( $link.attr('href') ),
         inv = $link.data('inv'),
         api_url = '/path/to/server/' + inv;

     // use `$.ajax` shorthand method to retrieve html
     // or use `$.getJSON` and a template
     $form_modal.find('.content').load(api_url, function(){
          // html from server exists now
          // run the modal open code here
          $form_modal.modalScriptOpen()
     });
});