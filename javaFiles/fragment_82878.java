$.ajax({
    method: 'DELETE',
    url: `/vacation/${vacation.id}`, // assuming your object vacation has an id field.
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

@RequestMapping(value = "/vacation/{vacationId}", method = RequestMethod.DELETE)
public String deleteCalendarEvents (@PathVariable int vacationId, HttpSession session){
    //code
}