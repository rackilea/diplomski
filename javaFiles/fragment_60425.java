@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface MessageMapper {

    @Mapping(target = "clientFrom", source = "from")
    @Mapping(target = "clientTo", source = "to")
    Message toMessage(MessageDTO messageDTO);

    @InheritInverseConfiguration //MapStruct will automatically reverse the defined mappings from toMessage
    MessageDTO toMessageDTO(Message message);

    List<Message> toMessageList(List<MessageDTO> list);
    List<MessageDTO> toMessageDTOList(List<Message> list);
}