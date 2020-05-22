public enum Suit { Spade, Heart, Diamond, Club }

Suit theSuit = Suit.Heart;

szQuery = "INSERT INTO Customers (Name, Suit) " +
          "VALUES ('Ian Boyd', %s)".format(theSuit.name());