<smifn:actionsMenu id="tableAddMeetingRoom" styleClass="col-xs-8 col-md-12 text-right"
                    onclick="@this.update()"
                    title="#{msg['booking.add_meeting_room']}">
                    <c:forEach items="#{homeReceptionDashboardBck.meetingRoomByOffice}" var="meetingRoomElement">
                        <p:menuitem id="#{homeReceptionDashboardBck.getMenuItemId(meetingRoomElement)}" 
                            action="#{homeReceptionDashboardBck.onAddPanel(meetingRoomElement)}" 
                            process="@this"
                            value="#{meetingRoomElement.name}" 
                            icon="icon-add-3" 
                            iconPos="left"
                            update ="widgetBookingReception">
                        </p:menuitem>       <!--  oncomplete="PF('bookingSelect').show()"-->
                    </c:forEach>
                </smifn:actionsMenu>