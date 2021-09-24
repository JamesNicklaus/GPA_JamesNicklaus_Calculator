package com.example.gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    TextView mTextViewHeader, mTextView1, mTextView2, mTextView3, mTextView4, mTextView5, mTextView6;
    Button mButton;
    EditText mEditText1, mEditText2, mEditText3, mEditText4, mEditText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewHeader = (TextView)findViewById(R.id.tvHeader);
        mTextView1 = (TextView)findViewById(R.id.tvEntry1);
        mTextView2 = (TextView)findViewById(R.id.tvEntry2);
        mTextView3 = (TextView)findViewById(R.id.tvEntry3);
        mTextView4 = (TextView)findViewById(R.id.tvEntry4);
        mTextView5 = (TextView)findViewById(R.id.tvEntry5);

        mTextView6 = (TextView) findViewById(R.id.tvCalc);

        mEditText1 = (EditText) findViewById(R.id.etEntry1);
        mEditText2 = (EditText) findViewById(R.id.etEntry2);
        mEditText3 = (EditText) findViewById(R.id.etEntry3);
        mEditText4 = (EditText) findViewById(R.id.etEntry4);
        mEditText5 = (EditText) findViewById(R.id.etEntry5);

        mButton = (Button) findViewById(R.id.button);

        }

    public void calculateGPA(View view) {

        if (TextUtils.isEmpty(mEditText1.getText()) ||
                TextUtils.isEmpty(mEditText2.getText()) ||
                TextUtils.isEmpty(mEditText3.getText()) ||
                TextUtils.isEmpty(mEditText4.getText()) ||
                TextUtils.isEmpty(mEditText5.getText())) {

            Snackbar sb = Snackbar.make(view, "Please fill all fields", Snackbar.LENGTH_LONG);
            sb.show();
            return;
        }
        int gpa = (Integer.parseInt(mEditText1.getText().toString()) +
                Integer.parseInt(mEditText2.getText().toString()) +
                Integer.parseInt(mEditText3.getText().toString()) +
                Integer.parseInt(mEditText4.getText().toString()) +
                Integer.parseInt(mEditText5.getText().toString())) / 5;

        mTextView6.setText(""+gpa);

        mButton.setText(R.string.ClearForm);

        if (gpa <= 60) {
            mTextView6.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        else if (gpa < 80) {
            mTextView6.setBackgroundColor(Color.parseColor("#F7FF00"));
        }
        else {
            mTextView6.setBackgroundColor(Color.parseColor("#11A500"));
        }

    }
}