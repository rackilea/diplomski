@Enumerated( EnumType.STRING )
@Column( name = "gender", length = 500, nullable = false )
private Gender gender;

@Enumerated( EnumType.STRING )
@Column( name = "section", length = 500, nullable = false )
private Section section;