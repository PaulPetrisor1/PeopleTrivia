package com.cg.peopletrivia;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class PoliticiansActivity extends AppCompatActivity {

    private QuestionList nQuestionList = new QuestionList();


    private TextView nScoreView;
    private ImageView nQuestionView;
    private Button nButtonChoice1;
    private Button nButtonChoice2;
    private Button nButtonChoice3;
    private Button nButtonChoice4;
    private String nAnswer;
    private int nScore = 0;
    private int nQuestionNumber = 0;
    private int nQuestionLenght = nQuestionList.nQuestions.length;
    Random random;
    int selectedQuestions = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politicians);

        random = new Random();


        nScoreView = (TextView) findViewById(R.id.score);
        nQuestionView = (ImageView) findViewById(R.id.lenin_question);
        nButtonChoice1 = (Button) findViewById(R.id.choice1);
        nButtonChoice2 = (Button) findViewById(R.id.choice2);
        nButtonChoice3 = (Button) findViewById(R.id.choice3);
        nButtonChoice4 = (Button) findViewById(R.id.choice4);



        updateQuestion(selectedQuestions);




        //Button 1 Listener

        nButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice1.getText() == nAnswer) {

                    nScore = nScore + 1;
                    updateScore(nScore);
                    updateQuestion(selectedQuestions);
                    Toast.makeText(PoliticiansActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                } else {
                    gameover();
                }


            }
        });



//end of button listener


        nButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice2.getText() == nAnswer) {

                    nScore = nScore + 1;
                    updateScore(nScore);
                    updateQuestion(selectedQuestions);
                    Toast.makeText(PoliticiansActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                } else {

                    gameover();

                }
            }
        });

        nButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice3.getText() == nAnswer) {

                    nScore = nScore + 1;
                    updateScore(nScore);
                    updateQuestion(selectedQuestions);
                    Toast.makeText(PoliticiansActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                } else {

                    gameover();
                }
            }
        });


        nButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nButtonChoice4.getText() == nAnswer) {

                    nScore = nScore + 1;
                    updateScore(nScore);
                    updateQuestion(selectedQuestions);
                    Toast.makeText(PoliticiansActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                } else {
                    gameover();
                }

            }
        });


    }

    private void updateQuestion(int nQuestionNumber) {


        selectedQuestions = random.nextInt(nQuestionLenght);
        nQuestionView.setImageResource(nQuestionList.nQuestions[selectedQuestions]);


        nButtonChoice1.setText(nQuestionList.getChoice1(selectedQuestions));
        nButtonChoice2.setText(nQuestionList.getChoice2(selectedQuestions));
        nButtonChoice3.setText(nQuestionList.getChoice3(selectedQuestions));
        nButtonChoice4.setText(nQuestionList.getChoice4(selectedQuestions));

        nAnswer = nQuestionList.getCorrectAnswer(selectedQuestions);


    }




    private void updateScore(int point) {

        nScoreView.setText(""  + nScore);
    }

    private void gameover() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PoliticiansActivity.this);

        if (nScore < 10) {
            alertDialogBuilder
                    .setMessage("You are bad! Your score is " + nScore)
                    .setCancelable(false)
                    .setPositiveButton("PLAY AGAIN",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(getApplicationContext(), PoliticiansActivity.class));

                                }
                            })

                    .setNegativeButton("EXIT",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }


        if (nScore > 10 ) {
            alertDialogBuilder
                    .setMessage("Not Bad! Your score is " + nScore)
                    .setCancelable(false)
                    .setPositiveButton("PLAY AGAIN",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(getApplicationContext(), PoliticiansActivity.class));

                                }
                            })

                    .setNegativeButton("EXIT",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }


    }


}



