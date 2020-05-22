@defining( 1 ){ wd =>

    @for(i <- 1 to 7){
        @if(i>=wd) {  
            <td>@cur++</td>
        } else {
            <td></td>
        }
    } 
}