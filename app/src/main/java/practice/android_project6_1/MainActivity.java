package practice.android_project6_1;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    RadioButton r1;
    RadioButton r2;
    Chronometer ch;
    TimePicker ti;
    CalendarView ca;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                ch.setTextColor(Color.RED);
            }
        });

        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        ch = (Chronometer) findViewById(R.id.chronometer2);
        ti = (TimePicker) findViewById(R.id.timePicker);
        ca = (CalendarView) findViewById(R.id.calendarView);

        r1.setChecked(true);
        ti.setVisibility(View.GONE);
        ca.setVisibility(View.VISIBLE);


        if(r2.isChecked())
        {
            ca.setVisibility(View.GONE);
            ti.setVisibility(View.VISIBLE);
        }
        else
            ti.setVisibility(View.GONE);
            ca.setVisibility(View.VISIBLE);

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        t1 = (TextView) findViewById(R.id.textView3);



    }
}
