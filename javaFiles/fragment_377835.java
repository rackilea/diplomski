#{form @createTargets()}

    #{field 'january[0]'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'february[0]'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'march[0]'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}

    #{field 'january[1]'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'february[1]'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'march[1]'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
#{/form}