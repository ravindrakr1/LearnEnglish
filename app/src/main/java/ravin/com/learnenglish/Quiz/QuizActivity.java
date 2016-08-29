package ravin.com.learnenglish.Quiz;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import ravin.com.learnenglish.R;

public class QuizActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView  timerView;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    private ArrayList<CheckBox> checkBoxOptions = new ArrayList<CheckBox>();
    private ArrayList<Question> questions;
    private Integer currentQuestionIndex ;
    private  CounterClass timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        this.setUpView(); // to set up Intial View

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    private  void setUpView() {

        TextView quizTitleView = (TextView) this.findViewById(R.id.QuizTitle);
        quizTitleView.setKeyListener(null);
        quizTitleView.setText("Antonyms - English Aptitude ");
        // the textview in which score will be displayed
        TextView scoreView = (TextView) this.findViewById(R.id.ScoreTitle);
        scoreView.setKeyListener(null);
        scoreView.setText("Score: 30");
        //Total question View
        TextView totalQuestView = (TextView) this.findViewById(R.id.totlaQuestion);
        totalQuestView.setKeyListener(null);
        totalQuestView.setText("40/100");

        this.mProgress = (ProgressBar) findViewById(R.id.QuizProgess);
        this.mProgress.setProgress(40);

        this.questions = this.getQuestions();
        this.currentQuestionIndex = 0;
        this.togglePreviousButton(true);
        this.setQuestion();
        // Adding check box

//        this.checkBoxOptions.add(option1);
//        this.checkBoxOptions.add(option2);
//        this.checkBoxOptions.add(option3);
//        this.checkBoxOptions.add(option4);
    }

    private void setQuestion(){

        if (currentQuestionIndex > this.questions.size()){
            return;
        }
        Question question = this.questions.get(currentQuestionIndex);
        TextView questionView = (TextView) this.findViewById(R.id.questionView);
        questionView.setKeyListener(null);
        questionView.setText(question.getQuestion());
        CheckBox option1 =  (CheckBox)findViewById(R.id.option1);
        option1.setText(question.getFirstOption());
        CheckBox option2 =  (CheckBox)findViewById(R.id.option2);
        option2.setText(question.getSecondOption());
        CheckBox option3 =  (CheckBox)findViewById(R.id.option3);
        option3.setText(question.getThirdOption());
        CheckBox option4 =  (CheckBox)findViewById(R.id.option4);
        option4.setText(question.getFourthOption());

        // the timer
        this.timerView = (TextView) this.findViewById(R.id.timerTitle);
        this.timerView.setKeyListener(null);
        this.timerView.setText("00:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        if (null != this.timer){
            this.timer.cancel();
        }
        this.timer = null;

        this.timer = new CounterClass(60000, 1000);
        this.timer.start();
    }

    public void getAnswer(String AnswerString){

    }

    // Temp function to create DemoQuestion
    private ArrayList<Question> getQuestions(){
        ArrayList<Question> tempQuestionArray = new ArrayList<Question>();
        tempQuestionArray.add(0,new Question(0, "Foremost :","Hindmost","Unimportant","Disposed","Mature","Unimportant",false));
        tempQuestionArray.add(1,new Question(1, "Protects : ","Defends","Deprives","Deserts ","Devises","Deserts",false));
        tempQuestionArray.add(2,new Question(2, "Beautiful :","Wonderful","Ugly","Marvelous ","Graceful","Ugly",false));
        tempQuestionArray.add(3,new Question(3, "Terrible :","Soothing","Delectable","Frightening","Scaring","Delectable",false));
        return tempQuestionArray;
    }

   // End temp Funtcion

    // Button click Actions
    public void onButtonClicked(View view){
        switch (view.getId()){
            case R.id.perviousQuestion:
                this.handelPreviousButtonAction();
            break;
            case R.id.nextQuestion:
                this.handelNextButtonAction();
            break;
            case R.id.submit:
            break;
            default:
                break;
        }
    }
    //End Button Click Action


    // Handel previous Button Action
    private void handelPreviousButtonAction(){
        currentQuestionIndex--;
        if (0  > currentQuestionIndex){
            // for type safety
            return;
        }else if (0 == currentQuestionIndex ){
            this.togglePreviousButton(true);
        }else if (this.questions.size() - 2   == currentQuestionIndex){
            this.toggleNextButton(false);
        }
        this.setQuestion();
    }
    // End previous Button Action

    // Next Button Action
    private void handelNextButtonAction(){
        currentQuestionIndex++;
        Integer maxLimit = this.questions.size();
        if (currentQuestionIndex >= maxLimit){
            // for type safety
            return;
        }else if (currentQuestionIndex  == maxLimit - 1){
            this.toggleNextButton(true);
        }else if (1 == currentQuestionIndex){
            this.togglePreviousButton(false);
        }
        this.setQuestion();
    }
    //End Next button action

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        Question question = this.questions.get(currentQuestionIndex);

        if (question.getIsMultipleChoice()){
            Iterator<CheckBox> itr = this.checkBoxOptions.iterator();
            while (itr.hasNext()){
                CheckBox opt = (CheckBox) itr.next();
                opt.setChecked(false);
            }
            ((CheckBox) view).setChecked(checked);
        }else {
            ((CheckBox) view).setChecked(checked);
        }
        // ((CheckBox) view).setChecked(true);

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.option1:
                break;
            case R.id.option2:
                break;
            case R.id.option3:
                break;
            case R.id.option4:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_camera:
                break;
            case  R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Hide and show previous Button when it is displaying First question
    private void togglePreviousButton(Boolean value){
        Button previousButton = (Button)findViewById(R.id.perviousQuestion);
        if (value){
            previousButton.setVisibility(View.GONE);
        }else{
            previousButton.setVisibility(View.VISIBLE);
        }

    }
    //End Hide and show previousButton

    // Hide and Show next button when it is displaying last question
    private void toggleNextButton(boolean value){
        Button nextButton = (Button) findViewById(R.id.nextQuestion);
        if (value){
            nextButton.setVisibility(View.GONE);
        }else{
            nextButton.setVisibility(View.VISIBLE);
        }
    }

    //End hide and show next button





    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }


        @Override
        public void onFinish() {
            timerView.setText("Time is up");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            timerView.setText(hms);
        }


    }
}
