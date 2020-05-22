@DeleteMapping("/delete/{matricule}")
public ResponseEntity supprimerUtilisateur( 
@PathVariable(name="matricule") String matricule) {
    if(matricule == null) {
        return ResponseEntity.badRequest().body("Impossible de supprimer un utilisateur, matricule null");
    }
    Utilisateur utilisateur = utilisateurRepository.getOne(matricule);
    if(utilisateur == null) {
        return ResponseEntity.notFound().build();
    }

    // Pass utilisateur => primaryKey in deleteById method
    utilisateurRepository.deleteById(utilisateur.getId());

    return ResponseEntity.ok("Utilisateur supprimé avec succès!");
}