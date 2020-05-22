node('remote') {

   ### - this stash appears to work - ### 
   stash name: "coverage$index", includes: "build/test/jacoco/jacoco${index}.exec"
   echo "stashed"

}
node('master') {
   echo "unstash coverage${it}"

   ### !!! this unstash causes an error !!! ###
   unstash name: "coverage${it}"
}