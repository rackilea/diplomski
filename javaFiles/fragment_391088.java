@(message: String)(title: String)(id: String)@main(title) {

<h2>@message</h2>

        <script type="text/javascript">

            function getPercentage()
            {

                $.ajax({
                    type: "GET",
                    url: "/status/@id",
                    dataType: "html",
                    success: function(html)
                        {
                        $('#status').html(html);


                        }
                });

            }

            $(document).ready(function() {


            setInterval("getPercentage()",100);
            });



        </script>

        <div id="status">

        </div>

}