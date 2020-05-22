@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping(value = "/findnotebydays/{days}/{canvasid}/{mode}")
public @ResponseBody List<INotes> findNotesByDays(@PathVariable("days")int days, @PathVariable("canvasid")int canvasid,
                                                  @PathVariable("mode")boolean mode ){

    if(!mode){
        return  this.groupNotesService.findGroupNotesByDays(days,canvasid);
    } else {
        return this.notesService.findNotesByDays(days,canvasid);
    }
}