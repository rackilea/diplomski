@Component
@Mapper(componentModel = "spring")
public interface IAppointmentMapper {

    @Mapping(target = "createdTime", ignore = true)
    @Mapping(target = "startTime", source = "dto", qualifiedByName = "startTime")
    @Mapping(target = "endTime", source = "dto", qualifiedByName = "endTime")
    Appointment convertAppointmentDTOToAppointment(AppointmentDTO dto, @Context DateTimeFormatter dateTimeFormatter);

    @Named("startTime")
    default OffsetDateTime mapStartTime(AppointmentDTO dto, @Context DateTimeFormatter dateTimeFormatter) {

        LocalDateTime localDateTime = LocalDateTime.parse(dto.getStartTime(), dateTimeFormatter); 
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(dto. getTimeZoneStart()));
        return zonedDateTime.toOffsetDateTime()
    }

    @Named("endTime")
    default OffsetDateTime mapEndTime(AppointmentDTO dto, @Context DateTimeFormatter dateTimeFormatter) {

        LocalDateTime localDateTime = LocalDateTime.parse(dto.getEndTime(), dateTimeFormatter); 
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(dto. getTimeZoneEnd()));
        return zonedDateTime.toOffsetDateTime()
    }
}