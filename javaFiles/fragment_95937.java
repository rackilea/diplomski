<textarea
    matInput
    rows="7"
    placeholder="Question body"
    maxlength="{{ modelConstraints['MAX_BODY_LENGTH'] }}"
    [(ngModel)]="questionBody"
  ></textarea>