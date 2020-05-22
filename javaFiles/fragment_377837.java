#{form @createTargets()}

    #{field 'targets[0].january'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'targets[0].february'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'targets[0].march'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}

    #{field 'targets[1].january'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'targets[1].february'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
    #{field 'targets[1].march'}
        <input type="number" name="${field.name}" value=""/>
    #{/field}
#{/form}