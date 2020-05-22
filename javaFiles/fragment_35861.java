@(users: List[Users], formList: List[Users],form: Form[Users])

@main("history") {

    @if (users.isEmpty) {
        <div class="alert">
            …
        </div>
    }

    @for(i <- users) {

        @if(i.client.equalsIgnoreCase("potato")) {

            <Table>
                <tbody>
                    <tr>
                        <td><a href="/#"><i >@i.firstname @i.lastname </i></a></td>
                        <td><a href="/#"><i>@i.phonenumber</i></a></td>
                        <td><a href="/#"><i>@i.amount</i></a></td>
                        <td><a href="/#"><i>@i.doneAt</i></a></td>
                        <td><a href="@routes.Application.edit(i.id)"><i><span class="glyphicon glyphicon-pencil "></span></i></a></td>
                        <td><a href="@routes.Application.delete(i.id) "><i><span class="glyphicon glyphicon-trash "></span></i></a></td>
                    </tr>
                </tbody>
            </table>
        }
    }
}