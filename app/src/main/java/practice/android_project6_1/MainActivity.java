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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    RadioButton r1;
    RadioButton r2;
    Chronometer ch;
    TimePicker ti;
    CalendarView ca;
    TextView t1;

    int year = 0;
    int month = 0;
    int day = 0;
    int hour = 0;
    int min = 0;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    flag=1;
                }
                else if(flag==1)
                {
                    Toast.makeText(getApplicationContext(),"예약을 완료해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
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

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r1.isChecked() == true)
                {
                    ti.setVisibility(View.INVISIBLE);
                    ca.setVisibility(View.VISIBLE);
                }
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r2.isChecked() == true)
                {
                    ca.setVisibility(View.INVISIBLE);
                    ti.setVisibility(View.VISIBLE);
                }
            }
        });


        b2 = (Button) findViewById(R.id.button2);
        t1 = (TextView) findViewById(R.id.textView3);

        ca.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int j, int k) {
                year=i;
                month=j;
                day=k;
            }
        });

        ti.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int j) {
                hour=i;
                min=j;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0)
                {
                    Toast.makeText(getApplicationContext(),"예약 시작버튼을 누르고 하셔야합니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(year==0 || hour==0)
                {
                    Toast.makeText(getApplicationContext(),"날짜 혹은 시간을 체크 하셔야합니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                ch.stop();
                ch.setTextColor(Color.BLUE);
                t1.setText(year+"년"+month+"월"+day+"일"+" "+hour+"시"+min+"분"+" 예약됨");
                flag=0;
            }
        });




    }
}
