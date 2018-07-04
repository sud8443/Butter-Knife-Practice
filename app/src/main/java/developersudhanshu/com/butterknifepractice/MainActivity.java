package developersudhanshu.com.butterknifepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview1) TextView textView;
    @BindView(R.id.button1) Button button;
    @BindColor(R.color.black) int blackColor;
    @BindDimen(R.dimen.dimen_20dp) int dimen20dp;
    @BindDimen(R.dimen.dimen_10dp) int dimen10dp;
    @BindString(R.string.text_hello_world) String text;
    @BindString(R.string.button_text) String buttonText;
    @BindString(R.string.button_two_text) String buttonTwoText;
    @BindString(R.string.text_button_pressed) String buttonPressedText;
    @BindString(R.string.text_button_released) String buttonReleasedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textView.setText(text);
        textView.setTextColor(blackColor);
        button.setText(buttonText);
        button.setPadding(dimen10dp, dimen20dp, dimen10dp, dimen20dp);
    }

    @OnClick(R.id.button2)
    public void buttonTwoClicked(){
        Toast.makeText(this, buttonTwoText + " Clicked!", Toast.LENGTH_SHORT).show();
    }

    @OnTouch(R.id.button1)
    public boolean onButtonTouched(Button button, MotionEvent motionEvent){
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                button.setText(buttonPressedText);
                return true;
            case MotionEvent.ACTION_UP:
                button.setText(buttonReleasedText);
                return true;
        }
        return false;
    }
}
