@Entity
@Table("cache_table_name")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
class CachedVersionOfOriginal extends Original {
 private Original original;
 public CachedVersionOfOriginal(Original original){
   this.original = original;
 }
//Then delegate
@Override
public String getPropertyA(){
  return orginal.getPropertyA();
}

}