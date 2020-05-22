telechargerPieceJointe(id: string): Promise<any> {
    const url = environment.rest.local.recupererDocument + '/' + id;
    const headers = new HttpHeaders({
        Accept: 'application/pdf'
    });

    return this.httpClient.get(url, { headers, responseType: 'blob' }).toPromise();
}