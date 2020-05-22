use lookahead to match any argument without passing over other arguments
pattern: \w+ (\w+)(?=(, \w+ \w+)*\)\);\n    })
replacement: $1
output:
public void jumpTo(double x, double y) {
    addAction(BasicActions.jumpTo(x, y));
}