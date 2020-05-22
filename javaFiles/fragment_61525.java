@Service
public class CardService {

    // ..

    public CreditCard registerCard(CreditCard card) throws BusinessException {
        if(cardDoesntBehaveToUser(card, currentUser()))) // you have to get the current user
            throw new BusinessException("This card doesn't behave to the current user");

        if(isExpired(card)) // you have to do this logic. this is just an example
            throw new BusinessException("The card is expired");

        return cardRepository.save(card);
    }

}