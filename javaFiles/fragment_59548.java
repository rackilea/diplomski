List<Note> notes = ...;

String currency = notes.isEmpty() ? null : notes.get(0).getCurrency();
if(!notes.stream().allMatch(e -> currency.equals(e.getCurrency())))
    throw new Exception();

System.out.println("Currency : " + currency);