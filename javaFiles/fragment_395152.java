Test data
    ---------

     List<Transaction> list = new  ArrayList<Transaction>();


    for (int i=0; i <= 10 ; i++){
        Transaction txn = new Transaction();

        txn.setClientId(i);
        txn.setEffDate("11/11/201"+i);
        txn.setSecCode("PPD");
        list.add(txn);
    }
    for (int i=0; i <= 5 ; i++){
        Transaction txn = new Transaction();

        txn.setClientId(i);
        txn.setEffDate("11/11/201"+i);
        txn.setSecCode("PPD");
        list.add(txn);
    }


    solution
    --------
    Map<Key, List<Transaction>> map = list.stream().collect(Collectors.groupingBy(Transaction::getKey));

    for (Key key : map.keySet()){
        System.out.println( "key effect ="+ key.getEffdate() + ", sec code =" +key.getSecCode() + " , client id ="+ key.getClientId());
        for( Transaction txn : map.get(key)){
            System.out.println( txn.getEffDate() + " "+ txn.getSecCode() + " " + txn.getClientId());
        }

    }


     Transaction.java 
     ----------------
     public class Transaction {

private int clientId;

private String secCode;

private String effDate;

public int getClientId() {
    return clientId;
}

public void setClientId(int clientId) {
    this.clientId = clientId;
}

public String getSecCode() {
    return secCode;
}

public void setSecCode(String secCode) {
    this.secCode = secCode;
}

public String getEffDate() {
    return effDate;
}

public void setEffDate(String effDate) {
    this.effDate = effDate;
}



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + clientId;
    result = prime * result + ((effDate == null) ? 0 : effDate.hashCode());
    result = prime * result + ((secCode == null) ? 0 : secCode.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Transaction other = (Transaction) obj;
    if (clientId != other.clientId)
        return false;
    if (effDate == null) {
        if (other.effDate != null)
            return false;
    } else if (!effDate.equals(other.effDate))
        return false;
    if (secCode == null) {
        if (other.secCode != null)
            return false;
    } else if (!secCode.equals(other.secCode))
        return false;
    return true;
}


public Key getKey() {
    return new Key(clientId, secCode,effDate);
}

class Key {

    public int getClientId() {
    return clientId;
}

public void setClientId(int clientId) {
    this.clientId = clientId;
}


    private int clientId;

    private String secCode;

    private String effdate;


    public Key(int clientId, String secCode,String effdate) {
        this.clientId = clientId;
        this.secCode = secCode;
        this.effdate = effdate;

    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public String getEffdate() {
        return effdate;
    }

    public void setEffdate(String effdate) {
        this.effdate = effdate;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + clientId;
        result = prime * result + ((effdate == null) ? 0 : effdate.hashCode());
        result = prime * result + ((secCode == null) ? 0 : secCode.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Key other = (Key) obj;
        if (clientId != other.clientId)
            return false;
        if (effdate == null) {
            if (other.effdate != null)
                return false;
        } else if (!effdate.equals(other.effdate))
            return false;
        if (secCode == null) {
            if (other.secCode != null)
                return false;
        } else if (!secCode.equals(other.secCode))
            return false;
        return true;
    }





}