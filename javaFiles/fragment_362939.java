List<Answer> listOfAnswer = new LinkedList<Answer>();
Answer answer;
...
if(line.contains("Answer")){
            //System.out.println("Contain Answer statement: " + line);
            count++;

            answer = new Answer(line);
            listOfAnswer.add(answer)
        }
        else{
            answer.add(new Answer(line));
        }
}
...