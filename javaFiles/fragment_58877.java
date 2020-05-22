String userAnswer = // ... getUserAnswer();        
if(userAnswer == null || userAnswer.equals("")
        || !userAnswer.matches("^-?\\d+$") 
            || userAnswer.split("(?<=\\G.{1})").length < 4) {
    // error    
}                

int[] secret = (int[])// ... getSecret(request);        
int[] seq = {1,2,3,4};

for(int i = 0; i < userAnswer.split("(?<=\\G.{1})").length; i++) {
    seq[i] = Integer.parseInt(s[i]);
}

int bullCount = 0;
int cowCount = 0;

for(int i = -1; ++i < secret.length;) {
  if(secret[i] == seq[i]) {
    bullCount++;
  }
}

for(int i = -1; ++i < secret.length;) {
  for(int j = -1; ++j < secret.length;) {
    if(secret[i] == seq[j] && i != j) {
      cowCount++;
    }
  }
}

String snswer = bullCount + "b" + cowCount +  "c";            
if(Arrays.equals(secret, seq))
 // win! 
else
// fail!