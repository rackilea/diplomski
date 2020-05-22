import groovy.transform.Field

@Field
def dateInternal = { new Date().format('yy.Mdd.Hmm') }.memoize()

def date() {
    dateInternal()
}