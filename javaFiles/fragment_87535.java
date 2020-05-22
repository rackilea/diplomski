<script>
    $("#genAddress").click(function () {
        $.ajax({
            type: "POST",
            url: 'generateAddress',

            success: function (data) {
                console.log("Wallet address generation success!")
            },

            failure: function (errMsg) {
                console.log(errMsg.toString())
            }
        });
    });
</script>