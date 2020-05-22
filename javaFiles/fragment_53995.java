@Autowired
private UserRepository userRepository;

User user = new User();
Patient patient = new Patient();
user.addPatient(patient);

// Just call save from userRepository to save your User with Patient.
// save method will return instance of saved user (together with instance of
// patient)
User user = userRepository.save(user);