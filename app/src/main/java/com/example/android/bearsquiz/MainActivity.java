package com.example.android.bearsquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    private RadioButton oneCorrectAnswer1985;
    private RadioButton twoCorrectAnswerWalterPayton;
    private RadioButton threeCorrectAnswerMike;
    private RadioButton fourCorrectAnswerJay;
    private EditText fiveCorrectAnswerDecatur;
    private CheckBox sixWrongAnswerGeorge;
    private CheckBox sixWrongAnswerLovie;
    private CheckBox sixCorrectAnswerJohn;
    private CheckBox sixCorrectAnswerMarc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneCorrectAnswer1985 = (RadioButton) findViewById(R.id.one_answer_correct_1985);
        twoCorrectAnswerWalterPayton = (RadioButton) findViewById(R.id.two_answer_correct_walter_payton);
        threeCorrectAnswerMike = (RadioButton) findViewById(R.id.three_answer_correct_mike);
        fourCorrectAnswerJay = (RadioButton) findViewById(R.id.four_answer_correct_jay);
        fiveCorrectAnswerDecatur = findViewById(R.id.five_answer_correct_decatur);
        sixWrongAnswerGeorge = (CheckBox) findViewById(R.id.six_answer_wrong_george);
        sixWrongAnswerLovie = (CheckBox) findViewById(R.id.six_answer_wrong_lovie);
        sixCorrectAnswerJohn = (CheckBox) findViewById(R.id.six_answer_correct_john);
        sixCorrectAnswerMarc = (CheckBox) findViewById(R.id.six_answer_correct_marc);
    }


    /**
     * This method is called when the Submit Answers button is clicked.
     */
    public void submitAnswers(View view) {
        boolean oneAnswer = oneCorrectAnswer1985.isChecked();
        boolean twoAnswer = twoCorrectAnswerWalterPayton.isChecked();
        boolean threeAnswer = threeCorrectAnswerMike.isChecked();
        boolean fourAnswer = fourCorrectAnswerJay.isChecked();
        String fiveAnswer = fiveCorrectAnswerDecatur.getText().toString().trim();
        boolean sixAnswer = !sixWrongAnswerGeorge.isChecked() && !sixWrongAnswerLovie.isChecked() && sixCorrectAnswerJohn.isChecked() && sixCorrectAnswerMarc.isChecked();


        score = calculateTotal(oneAnswer, twoAnswer, threeAnswer, fourAnswer, fiveAnswer, sixAnswer);
        String totalMessage = submitAnswersScore(score);

        Context context = getApplicationContext();
        CharSequence text = totalMessage;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Prints message after the order.
     *
     * @param calculatedScore is the current score of the quiz.
     * @return is the message that will print in the toast.
     */
    private String submitAnswersScore(int calculatedScore) {
        String totalMessagePerfect = "Great Job! You finished with a score of " + calculatedScore + " out of 6!";
        totalMessagePerfect += "\nYou really know your Bears history!";
        totalMessagePerfect += "\nThanks for taking my quiz!";

        String totalMessageAlmost = "Great Try! You finished with a score of " +calculatedScore + " out of 6.";
        totalMessageAlmost += "\nThanks for taking my quiz!";

        if (calculatedScore == 6) {
            return totalMessagePerfect;
        }
        else {
            return totalMessageAlmost;
        }
    }


    /**
     * Calculates the total of the score.
     *
     * @param oneAnswer   is if question 1 was answered correctly.
     * @param twoAnswer   is if question 2 was answered correctly.
     * @param threeAnswer is if question 3 was answered correctly.
     * @param fourAnswer  is if question 4 was answered correctly.
     * @param fiveAnswer  is if question 5 was answered correctly.
     * @param sixAnswer is if the question 6 was answered correctly.
     * @return total message
     */
    private int calculateTotal(boolean oneAnswer, boolean twoAnswer, boolean threeAnswer, boolean fourAnswer, String fiveAnswer, boolean sixAnswer) {
        int calculateTotal = 0;

        if (oneAnswer) {
            calculateTotal = calculateTotal + 1;
        }
        if (twoAnswer) {
            calculateTotal = calculateTotal + 1;
        }
        if (threeAnswer) {
            calculateTotal = calculateTotal + 1;
        }
        if (fourAnswer) {
            calculateTotal = calculateTotal + 1;
        }
        if (fiveAnswer.equalsIgnoreCase("Decatur Staleys")) {
            calculateTotal = calculateTotal + 1;
        }
        if (sixAnswer) {
            calculateTotal = calculateTotal + 1;
        }

        return calculateTotal;
    }


}
