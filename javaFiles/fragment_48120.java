db.dummy.aggregate( 
{
    $project:
    {
        User_ID:1,
        User_Status:"$Status.User_Status"
    }
})