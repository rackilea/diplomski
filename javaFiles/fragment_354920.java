activity{
        onCreate{
            makeNextQuestion(1)
        }

        public void nextQuestion(int questionId){
            //add string and answering buttons to layout
            btn.onClickList(){
                onClick(View btn){
                    activity.this.nextQuestion(btn.getId());
                }
            }
        }
    }