package ravin.com.learnenglish.Quiz;

import android.app.Activity;

/**
 * Created by mayankg on 29/08/16.
 */


public class Question  extends Activity {
    private Integer questionId;
    private String question;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;
    private String answer;
    private Boolean isMultipleChoice;

    public Question(){
        super();
        this.questionId = -5 ; // for invalid questions
        this.question = this.firstOption = this.secondOption = this.thirdOption = this.fourthOption = this.answer =  "";
    }

    public Question(Integer questionId,String question, String firstOption, String secondOption, String thirdOption, String fourthOption, String answer, boolean choiceType){
        super();
        this.questionId = questionId;
        this.question = question;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
        this.fourthOption = fourthOption;
        this.answer = answer;
        this.isMultipleChoice = choiceType;
    }
    public Integer getQuestionid(){
        return this.questionId;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getFirstOption(){
        return this.firstOption;
    }
    public String getSecondOption(){
        return this.secondOption;
    }
    public String getThirdOption(){
        return this.thirdOption;
    }
    public String getFourthOption(){
        return this.fourthOption;
    }
    public String getAnswer(){
        return  this.answer;
    }
    public Boolean getIsMultipleChoice(){
        return this.isMultipleChoice;
    }
    public void setQuestionId(Integer id){
        this.questionId = id;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public void setFirstOption(String firstOption){
        this.firstOption = firstOption;
    }
    public  void setSecondOption(String secondOption){
        this.secondOption = secondOption;
    }
    public  void setThirdOption(String thirdOption){
        this.thirdOption = thirdOption;
    }
    public void setFourthOption(String fourthOption){
        this.fourthOption = fourthOption;
    }
    public  void setAnswer(String answer){
        this.answer = answer;
    }
    public void setIsMultipleChoice(boolean choiceType){
        this.isMultipleChoice = choiceType;
    }
}
