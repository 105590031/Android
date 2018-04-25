package tw.edu.ntut.csie.app01_105590031;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSex, mEdtAge;
    private Button mBtnOK;
    private TextView mTxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSex = (EditText) findViewById(R.id.edtSex);

        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtR = (TextView) findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String strSex = mEdtSex.getText().toString();
            int iAge = Integer.parseInt(mEdtSex.getText().toString());

            String strSug = getString(R.string.suggestion);
            if (iAge > 100 ) {
                strSug += getString(R.string.sug_not_hurry100);
                Log.d("MarriSug", "grade = x");
            } else if (iAge <= 100 && iAge>=90) {
                strSug += getString(R.string.sug_not_hurry90);
                Log.d("MarriSug", "grade = A");
            } else if (iAge <= 89 && iAge>=80) {
                strSug += getString(R.string.sug_not_hurry80);
                Log.d("MarriSug", "grade = B");
            } else if (iAge <= 79 && iAge>=70) {
                strSug += getString(R.string.sug_not_hurry70);
                Log.d("MarriSug", "grade = C");
            } else if (iAge <= 69 && iAge>=60) {
                strSug += getString(R.string.sug_not_hurry60);
                Log.d("MarriSug", "grade = D");
            } else if (iAge <= 59 && iAge>=0) {
                strSug += getString(R.string.sug_not_hurry59);
                Log.d("MarriSug", "grade = F");
            } else if (iAge <0) {
                strSug += getString(R.string.sug_not_hurry100);
                Log.d("MarriSug", "grade = x");
            }


            mTxtR.setText(strSug);
        }
    };
}

