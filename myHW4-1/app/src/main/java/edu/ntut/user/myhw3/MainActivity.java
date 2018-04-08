package edu.ntut.user.myhw3;

import android.content.res.Resources;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivity self;

    private RadioGroup mRdgSex;
    private RadioButton mRdoMale;
    private RadioButton mRdoFemale;
    private Spinner mSpAge;
    private ArrayList<CheckBox> listChkHabits;
    private Button mBtnOK;
    private TextView mTvSug;
    private TextView mTvHabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;

        mRdgSex = (RadioGroup) findViewById(R.id.rdgSex);
        mRdoMale = (RadioButton) findViewById(R.id.rdoMale);
        mRdoFemale = (RadioButton) findViewById(R.id.rdoFemale);
        mSpAge = (Spinner) findViewById(R.id.spAge);

        listChkHabits = new ArrayList<>();
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Music));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Sing));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Dance));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Travel));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Reading));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Writing));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Climbing));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Swim));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Eating));
        listChkHabits.add((CheckBox) findViewById(R.id.chkHabit_Drawing));

        mBtnOK = (Button) findViewById(R.id.btnOK);                             // 「確定」按鈕
        mTvSug = (TextView) findViewById(R.id.tvSug);                          // 「建議」文字
        mTvHabit = (TextView) findViewById(R.id.tvHabit);                      // 「興趣」文字


        mRdgSex.setOnCheckedChangeListener(spAge_OnCheckedChange);              // 當「性別」更動時
        mBtnOK.setOnClickListener(btnOKOnClick);                                // 當「確定」被按下時
    }


    private RadioGroup.OnCheckedChangeListener spAge_OnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            RadioButton target = (RadioButton) radioGroup.findViewById(id);
            Resources res = getResources();
            ArrayAdapter<String> adapter;

            if (target == mRdoMale) {
                adapter = new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, res.getStringArray(R.array.maleAgeList));
            }
            else {
                adapter = new ArrayAdapter<String>(self, android.R.layout.simple_list_item_1, res.getStringArray(R.array.femaleAgeList));
            }

            mSpAge.setAdapter(adapter);
        }
    };


    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MarriageSuggestion ms = new MarriageSuggestion();           // 建立「婚姻建議」物件
            boolean isMale = mRdoMale.isChecked();
            String sexStr = isMale ? "male" : "female";

            if (isMale) {
                switch(mSpAge.getSelectedItem().toString()) {
                    case "小於30歲":
                        mTvSug.setText(ms.getSuggestion(sexStr, 1));
                        break;
                    case "30~40歲":
                        mTvSug.setText(ms.getSuggestion(sexStr, 2));
                        break;
                    case "大於40歲":
                        mTvSug.setText(ms.getSuggestion(sexStr, 3));
                }
            }
            else {
                switch(mSpAge.getSelectedItem().toString()) {
                    case "小於28歲":
                        mTvSug.setText(ms.getSuggestion(sexStr, 1));
                        break;
                    case "28~35歲":
                        mTvSug.setText(ms.getSuggestion(sexStr, 2));
                        break;
                    case "大於35歲":
                        mTvSug.setText(ms.getSuggestion(sexStr, 3));
                }
            }


            String habitInfo = "興趣: ";
            for (CheckBox radio : listChkHabits) {
                if (radio.isChecked()) {
                    habitInfo += radio.getText().toString() + " ";
                }
            }

            mTvHabit.setText(habitInfo);
        }
    };
}