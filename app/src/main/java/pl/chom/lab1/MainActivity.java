package pl.chom.lab1;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;

    final String pytania[] = {
            "Pytanie pierwsze",
            "Pytanie drugie",
            "Pytanie trzecie"
    };

    final String odpowiedzi[][] = {
            new String[]{
                    "Odpowiedź pierwsza",
                    "Odpowiedź druga",
                    "Odpowiedź trzecia",
            },
            new String[]{
                    "Odpowiedź pierwsza na drugie pytanie",
                    "Odpowiedź druga na drugie pytanie",
                    "Odpowiedź trzecia na drugie pytanie",
                    "Odpowiedź czwarta na drugie pytanie",
            },
            new String[]{
                    "Coś",
                    "Coś innego",
            },
    };

    final int poprawneOdpowiedzi[] = {
            0,
            3,
            1,
    };

    private int currentQuestionId = 0;

    private ArrayList<TextView> correctTextList = new ArrayList<>();
    private final ArrayList<Button> buttonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LayoutInflater inflater = LayoutInflater.from(this);
        container = (LinearLayout) findViewById(R.id.buttonContainer);

        replaceQuestionButtons(inflater, currentQuestionId);

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceQuestionButtons(inflater, currentQuestionId);
            }
        });
    }

    private void onAnswer(int answerId) {
        int correctAnswerId = poprawneOdpowiedzi[currentQuestionId];

        TextView correctText = correctTextList.get(correctAnswerId);
        correctText.setVisibility(View.VISIBLE);

        for (Button button : buttonList) {
            button.setEnabled(false);
        }

        currentQuestionId++;

        if (currentQuestionId >= pytania.length)
        {
            TextView textEnd = (TextView) findViewById(R.id.textEnd);
            textEnd.setVisibility(View.VISIBLE);
        } else {
            Button nextButton = (Button) findViewById(R.id.nextButton);
            nextButton.setEnabled(true);
        }
    }

    private void replaceQuestionButtons(LayoutInflater inflater, int questionId) {
        container.removeAllViews();
        correctTextList.clear();
        buttonList.clear();

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setEnabled(false);

        TextView textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setText(pytania[questionId]);

        for (int i = 0; i < odpowiedzi[questionId].length; i++) {
            String odpowiedz = odpowiedzi[questionId][i];

            View view = inflater.inflate(R.layout.item_button, null);

            Button button = (Button) view.findViewById(R.id.button);
            buttonList.add(button);
            button.setText(odpowiedz);

            final TextView textSelected = (TextView) view.findViewById(R.id.textView);
            textSelected.setVisibility(View.INVISIBLE);

            final TextView textCorrect = (TextView) view.findViewById(R.id.textView2);
            correctTextList.add(textCorrect);
            textCorrect.setVisibility(View.INVISIBLE);

            final int finalI = i; // idiotyzm.
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textSelected.setVisibility(View.VISIBLE);
                    onAnswer(finalI);
                }
            });

            container.addView(view);
        }
    }
}