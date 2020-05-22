$.ajax({
    method: 'GET',
    url: '/vacation/deleteEvents',
    success: function (response) {
        if (response !== "OK")
            alert(response);
        else
            console.log(response);
    },
    error: function (e) {
        console.log(e);
    }
});

@RequestMapping(value = "/vacation/deleteEvents", method = RequestMethod.GET)
public String deleteCalendarEvents (HttpSession session){
    //code
}