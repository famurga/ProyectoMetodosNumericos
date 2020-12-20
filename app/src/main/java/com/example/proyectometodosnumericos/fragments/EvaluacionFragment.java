package com.example.proyectometodosnumericos.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.proyectometodosnumericos.R;
import com.example.proyectometodosnumericos.TableDynamic;

import java.util.ArrayList;


public class EvaluacionFragment extends Fragment {

    public static final String CORRECT_ANSWER = "correct_answer";
    public static final String CURRENT_QUESTION = "current_question";
    public static final String ANSWER_IS_CORRECT = "answer_is_correct";
    public static final String ANSWER = "answer";

    private int ids_answers[] = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };
    private String[] all_questions;

    private TextView text_question;
    private RadioGroup group;
    private Button btn_next, btn_prev;

    private int correct_answer;
    private int current_question;
    private boolean[] answer_is_correct;
    private int[] answer;
    View v;


    public void onSaveInstanceState(Bundle outState){
        Log.i("lifecycle", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt(CORRECT_ANSWER, correct_answer);
        outState.putInt(CURRENT_QUESTION, current_question);
        outState.putBooleanArray(ANSWER_IS_CORRECT, answer_is_correct);
        outState.putIntArray(ANSWER, answer);
    }

    @Override
    public void onStop() {
        Log.i("lifecycle", "onStop");
        super.onStop();
    }

    @Override
    public void onStart() {
        Log.i("lifecycle", "onStart");
        super.onStart();
    }

    @Override
    public void onDestroy() {
        Log.i("lifecycle", "onDestroy");
        super.onDestroy();
    }

    public void onCreate(Bundle savedInstanceState) {
        Log.i("lifecycle", "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         v = inflater.inflate(R.layout.fragment_evaluacion, container, false);

        text_question = (TextView) v.findViewById(R.id.text_question);
        group = (RadioGroup) v.findViewById(R.id.answer_group);
        btn_next = (Button) v.findViewById(R.id.btn_check);
        btn_prev = (Button) v.findViewById(R.id.btn_prev);

        int aleatorio=(int)(Math.floor(Math.random()*(2-0+1)+0));
        Log.e("Aleatorio","Aleatorio vale"+aleatorio);

        if(aleatorio==0){
            all_questions = getResources().getStringArray(R.array.all_questions);
        }
        else if(aleatorio==1){
            all_questions = getResources().getStringArray(R.array.all_questions2);
        }
        else if(aleatorio==2){
            all_questions = getResources().getStringArray(R.array.all_questions3);
        }





        if (savedInstanceState == null) {
            startOver();
        } else {
            Bundle state = savedInstanceState;
            correct_answer = state.getInt(CORRECT_ANSWER);
            current_question = state.getInt(CURRENT_QUESTION);
            answer_is_correct = state.getBooleanArray(ANSWER_IS_CORRECT);
            answer = state.getIntArray(ANSWER);
            showQuestion();
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question < all_questions.length-1) {
                    current_question++;
                    showQuestion();
                } else {
                    checkResults();
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                if (current_question > 0) {
                    current_question--;
                    showQuestion();
                }
            }
        });

        return v;
    }

    private void startOver() {
        answer_is_correct = new boolean[all_questions.length];
        answer = new int[all_questions.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        current_question = 0;
        showQuestion();
    }

    private void checkResults() {
        int correctas = 0, incorrectas = 0, nocontestadas = 0;
        for (int i = 0; i < all_questions.length; i++) {
            if (answer_is_correct[i]) correctas++;
            else if (answer[i] == -1) nocontestadas++;
            else incorrectas++;
        }

        // TODO: Permitir traducción de este texto:
        String message =
                String.format("Correctas: %d\nIncorrectas: %d\nNo contestadas: %d\n",
                        correctas, incorrectas, nocontestadas);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.results);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.finish, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });
        builder.setNegativeButton(R.string.start_over, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startOver();
            }
        });
        builder.create().show();
    }

    private void checkAnswer() {
        int id = group.getCheckedRadioButtonId();
        int ans = -1;
        for (int i = 0; i < ids_answers.length; i++) {
            if (ids_answers[i] == id) {
                ans = i;
            }
        }
        answer_is_correct[current_question] = (ans == correct_answer);
        answer[current_question] = ans;
    }

    private void showQuestion() {


        String q = all_questions[current_question];
        String[] parts = q.split(";");

        group.clearCheck();

        text_question.setText(parts[0]);
        for (int i = 0; i < ids_answers.length; i++) {
            RadioButton rb = (RadioButton) v.findViewById(ids_answers[i]);
            String ans = parts[i+1];
            if (ans.charAt(0) == '*') {
                correct_answer = i;
                ans = ans.substring(1);
            }
            rb.setText(ans);
            if (answer[current_question] == i) {
                rb.setChecked(true);
            }
        }
        if (current_question == 0) {
            btn_prev.setVisibility(View.GONE);
        } else {
            btn_prev.setVisibility(View.VISIBLE);
        }
        if (current_question == all_questions.length-1) {
            btn_next.setText(R.string.finish);
        } else {
            btn_next.setText(R.string.next);
        }
    }
}