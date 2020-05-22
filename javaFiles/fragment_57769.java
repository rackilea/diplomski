<script>
    $(function(){
        $('.publish').click(function(){
            title = $('#title').val();
            description = $('#description').val();
            article = $('#article').val();

            $.ajax({
                type:       "post",
                url:        "/articles",
                data:       {action:'add', title:title, description:description, article:article},
                // .... skipped unchanged lines
    </script>