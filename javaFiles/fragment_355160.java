int familyTickets = 0;

if (adults > childs){
    familyTickets = childs/2;
} else {
    familyTickets = adults/2;
}

int adultTickets = adults - familyTickets*2;
int childTickets = childs - familyTickets*2;