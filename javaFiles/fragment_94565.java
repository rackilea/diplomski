export class FrequencyTableComponent implements OnInit {
_postsArray: Array<any> = [];
 constructor(private tableService: TableService) { }

 ngOnInit() {

  this.tableService.getPosts().subscribe((data: any) => {
  console.log(data);
   Object.keys(data).forEach(key => {
    var obj1 = data[key];
    console.log('key is ' + key);
     Object.keys(obj1).forEach(key1 => {
      console.log('key inner is ' + key1 + ' val is ' + obj1[key1]);
      this._postsArray.push({k: key, l: key1, m: obj1[key1]});
    })
  });
  console.log('array is ' + this._postsArray.toString());

   });
  }