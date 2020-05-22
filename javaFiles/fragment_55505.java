node('remote') {
    ### - this stash works fine -###
    stash name: 'sources', includes: '**', excludes: '**/.git,**/.git/**'
}
node('remote') {    
    ### - this unstash works fine - ###
    unstash 'sources'
}