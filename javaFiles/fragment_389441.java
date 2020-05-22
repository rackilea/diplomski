for (int i = 1; i <= numberOfFlips; i++ )
{
    headOrTail = newFlip();    //update your new flip
    System.out.println("Flip " + i + ": " + headOrTail);
}

System.out.println("My last flip: " + headOrTail );