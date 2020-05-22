package company;

import company.salary.Income;
import company.salary.Expenditure;

public class Budget
{
    private List<Income> credits;
    private List<Expenditure> debits;

    // Other stuff here
    public Money calculateSavings()
    {
        Money savings = new Money();

        for (Income credit : credits)
        {
           savings.add(credit.getValue());
        }
        for (Expenditure debit : debuts)
        {
           savings.sub(debit.getValue());
        }

        return savings;
    }
}


package company.salary;

public class Income
{
    private Money value;

    public Money getValue() { return this.value; }
}

public class Expenditure
{
    private Money value;

    public Money getValue() { return this.value; }
}