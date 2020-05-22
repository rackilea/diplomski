@Entity
@Table("cache_table_name")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
class CachedVersionOfOriginal extends Original {
 //nothing here
}