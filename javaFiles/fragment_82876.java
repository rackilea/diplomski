$.ajax({
    method: 'POST',
    url: '/vacation/deleteEvents',
    contentType: 'application/json; charset=utf-8;',
    dataType: 'json',
    data: JSON.stringify(vacation),
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

@RequestMapping(value = "/vacation/deleteEvents", method = RequestMethod.POST)
public String deleteCalendarEvents (@RequestBody Vacation vacation, HttpSession session){
    //code
}