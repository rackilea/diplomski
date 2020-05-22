<mat-form-field *ngIf="competitionsList">
    <mat-select placeholder="Select Competition">
      <mat-option *ngFor="let comp of competitionsList; let i = index" [value]="comp">
        {{ comp.name }}
      </mat-option>
    </mat-select>
  </mat-form-field>