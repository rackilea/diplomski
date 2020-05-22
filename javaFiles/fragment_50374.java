@Component
@Getter
@Setter
@NoArgsConstructor
public class ConvertNonStandardOfferRequestDtoWrapper {
    private ConvertNonStandardOfferRequestDto convertNonStandardOfferRequestDto;

    private boolean documentPrintoutsRequired;

    public ConvertNonStandardOfferRequestDtoWrapper(ConvertNonStandardOfferRequestDto convertNonStandardOfferRequestDto, 
                                                    @Value("${yourproperty}") boolean documentPrintoutsRequired) {
        this.convertNonStandardOfferRequestDto = convertNonStandardOfferRequestDto;
        this.documentPrintoutsRequired = documentPrintoutsRequired;
    }
}