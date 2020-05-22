loadConstraints() {
    var url: string = "/questions/model-constraints";
    this.http
      .get(url)
      .subscribe((data: Map<string, number>) => (this.modelConstraints = data));
  }