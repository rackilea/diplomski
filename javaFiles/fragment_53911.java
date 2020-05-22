<display:table id="id" name="userList" pagesize="5" cellpadding="5px;"
                   cellspacing="5px;" style="margin-left:50px;margin-top:20px;" requestURI="">
    <display:column property="name"
         title="name" />
<display:column title="Action" value="Edit" href="EditUser"
            media="html" paramId="id" paramProperty="id"/>
    <display:column title="Action" value="Delete" href="DeleteUser"
        media="html" paramId="id" paramProperty="id"/>
</display:table>