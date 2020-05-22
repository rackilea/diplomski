double min_omegaF_restricted=Double.POSITIVE_INFINITY;
for(int f=0; f<F; f++){
    Firm fo=firms.get(f);
    if(predicate.test(fo))
        min_omegaF_restricted=Math.min(min_omegaF_restricted, fo.omegaF);
}