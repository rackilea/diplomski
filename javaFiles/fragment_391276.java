@Autowired
KingdomRepository kingdomRepository;

@Test
@Transactional
    public void getAllKingdomsTest() throws Exception {

        List<Kingdom> kingdoms = setUpAListOfKingdoms();

        kingdomRepository.saveAll(kingdoms);
        kingdomRepository.flush();

        mockMvc.perform(get("/Westeros").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name").value("TheNorth"))
                .andExpect(jsonPath("$[1].name").value("TheRiverlands"));
    }