<c:forEach items="${crFilingServiceListForm.unregisteredCaseRecipients}" var="unregisteredRecip">
    <c:forEach items="${unregisteredRecip.unregisteredCaseRecipientNotifications}" var="unregisteredNotification">
    <td style="width: 25px;">
        <input type="checkbox" name="docRecipNotify" id="docRecipNotify" value="${unregisteredNotification.id}" ${unregisteredNotification.notificationCheck}/>
    </td>
    </c:forEach>
    </tr>
</c:forEach>