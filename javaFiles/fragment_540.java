println db.configurations.count([name: 'Mike'])

def str = '''function(name) {
    return db.configurations.count({
        name: name
    });
}'''
println db.doEval(str, 'Mike')