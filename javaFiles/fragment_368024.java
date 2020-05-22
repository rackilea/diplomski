@RequestMapping(value="/api/contextsource/soldier",method= RequestMethod.POST)
    public Soldier addPeptide(@RequestBody Soldier soldier) {       
        for(Medal s: soldier.getMedals()) {
            Medal ss = medalService.getMedalById(s.getId());
            ss.getMedals().add(soldier);
            medalService.addMedal(ss);
        }           
        return null;
    }