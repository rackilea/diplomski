dna = dna.replace('A' , 'X');
dna = dna.replace('T' , 'A'); // only original Ts will become As 
dna = dna.replace('X' , 'T');
dna = dna.replace('G' , 'Y');
dna = dna.replace('C' , 'G'); // only original Cs will become Gs
dna = dna.replace('Y' , 'C');