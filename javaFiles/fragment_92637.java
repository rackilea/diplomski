$(document).ready(function () {
        $('#submit').click(function () {
            var activityRangelist = '';
            for (i = 0; i < activityRangeCBs.length; i++) {
                if (activityRangeCBs[i].checked === true) {
                    if (activityRangelist.length > 0) {
                        activityRangelist += ',';
                    }
                    activityRangelist += $(activityRangeCBs[i].parentNode).text();
                }
            }

            var dataToBeSent = {
                activityRangeCBs: activityRangelist,
            }; // you can change parameter name
            console.log(dataToBeSent);
            $.ajax({
                url: 'E1ActivityCreateView', // Your Servlet mapping or JSP(not suggested)
                data: dataToBeSent,
                type: 'POST',
            })
        });
    });