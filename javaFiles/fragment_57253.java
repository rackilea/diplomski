@RequestMapping(value = "/poem/add", method = RequestMethod.GET)
    public ModelAndView addPoemPage() {
        ModelAndView modelAndView = new ModelAndView("poem-add");
        Author author = new Author();
        Poem poem = new Poem();
        poem.setAuthor(author); 
        modelAndView.addObject("poem", new Poem());
        return modelAndView;
    }

    @RequestMapping(value = "/poem/add", method = RequestMethod.POST)
    public ModelAndView addingPoem(@ModelAttribute("poem") Poem poem) {

        ModelAndView modelAndView = new ModelAndView("home");
        authorService.addAuthor(poem.getAuthor);
        poemService.addPoem(poem);
        return modelAndView;
    }