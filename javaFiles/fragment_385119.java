pattern: (public void (\w+\((?:(?:final )?\w+ \w+(?:, )?)*\))) \{(?:.|\n)*?\n    \}
replacement: $1 {\n        addAction(BasicActions.$2);\n    }
output:
public void jumpTo(final double x, double y) {
    addAction(BasicActions.jumpTo(final double x, double y));
}