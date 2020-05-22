@Injectable()
export class TableService {

constructor(private http: HttpClient) {}
getPosts(): any {
return this.http.get('/getQueryCount');
}