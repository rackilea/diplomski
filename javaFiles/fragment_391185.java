DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Tickets;
CREATE TABLE IF NOT EXISTS Tickets (Ticket_id INTEGER PRIMARY KEY, Is_Available INTEGER DEFAULT 0);
CREATE TABLE IF NOT EXISTS Customer (Customer_id INTEGER PRIMARY KEY, Customer_name TEXT, Ticket_id INTEGER REFERENCES Tickets(Ticket_id) ON DELETE CASCADE ON UPDATE CASCADE);
CREATE TRIGGER IF NOT EXISTS setTicketAvailability AFTER INSERT ON Customer BEGIN UPDATE Tickets SET Is_Available = 1 WHERE Tickets.Ticket_id = new.Ticket_id; END;

INSERT INTO Tickets (Ticket_id) VALUES(null),(null),(null);
SELECT * FROM Tickets;
INSERT INTO Customer (Customer_name, Ticket_id) VALUES 
    ('Fred',3), -- Add Customer Fred booking ticket with id = 3
  ('Mary',1) -- Add Csutomer mary booking ticket with id 1
;
SELECT * FROM Tickets;
INSERT INTO Customer (Customer_name, Ticket_id) VALUES 
   ('Jane',2)
;
SELECT * FROM Tickets;