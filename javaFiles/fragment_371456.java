export class EntityService {

    public entity: EntityModel;
    private options: RequestOptions;

    constructor( @Inject(Http) private http: Http, @Inject(AuthenticationService) authService) {
        let headers = new Headers({ 
           'X-Authorization': 'Bearer ' + authService.token,
           'Content-Type': 'application/json'
        });
        this.options = new RequestOptions({ headers: headers, withCredentials: true });
    }

    public store(entity: EntityModel): Observable<string> {

        var request;
        if (!entity.uuid) {
            request = this.http.post("http://localhost:8080/api/entity", JSON.stringify(entity), this.options);
        }
        else {
            request = this.http.put("http://localhost:8080/api/entity", JSON.stringify(fact), this.options);
        }
        return request.map((res: Response) => res.text());
    }
}