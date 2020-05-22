if(sign == '=') {
    button.actionPerformed = { println '=' }
} else if(sign == 'C') {
    button.actionPerformed = { println 'clear' }
} else {
    button.actionPerformed = { println sign }
}