import java.util.stream.Collectors;

def sample = ['Groovy', 'Gradle', 'Grails', 'Spock'] as String[]  
def result = Arrays.stream(sample )
                        .filter { s -> s.startsWith('Gr') }                
                        .map { s -> s.toUpperCase() }                
                        .collect(Collectors.toList())​