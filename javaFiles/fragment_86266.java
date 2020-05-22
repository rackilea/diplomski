public DNASequence(String dna_sequence){
        the_sequence = dna_sequence; 
        complement_hmap.put('A', 'T');
        complement_hmap.put('T', 'A');
        complement_hmap.put('C', 'G');
        complement_hmap.put('G', 'C');
        nuc_content(dna_sequence);
    }