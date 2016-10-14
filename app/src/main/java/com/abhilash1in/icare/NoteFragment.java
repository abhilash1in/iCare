package com.abhilash1in.icare;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {


    EditText bodyEditText;
    TextView dateTextView;
    int yy,mm,dd,dayNum;
    String day;
    static final String TAG="NoteFragment";
    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_note, container, false);

        bodyEditText=(EditText)view.findViewById(R.id.bodyEdit);
        dateTextView=(TextView)view.findViewById(R.id.dateTextView);
        bodyEditText.requestFocus();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Diary entry saved!",Snackbar.LENGTH_LONG).setAction("Action",null).show();
                String data = bodyEditText.getText().toString();
                writeToDB();
            }
        });
        final Calendar c = Calendar.getInstance();
         yy = c.get(Calendar.YEAR);
         mm = c.get(Calendar.MONTH);
         dd = c.get(Calendar.DAY_OF_MONTH);
        dayNum = c.get(Calendar.DAY_OF_WEEK);
        Log.d(TAG,"day "+c.get(Calendar.DAY_OF_WEEK));

        switch (dayNum) {
            case Calendar.SUNDAY:
                day="Sunday";
                break;

            case Calendar.MONDAY:
               day="Monday";
                break;

            case Calendar.TUESDAY:
                day="Tuesday";
                break;
            case Calendar.WEDNESDAY:
                day="Wednesday";
                break;

            case Calendar.THURSDAY:
                day="Thursday";
                break;

            case  Calendar.FRIDAY:
                day="Friday";
                break;

            case Calendar.SATURDAY:
                day="Saturday";
                break;
        }

        String monthName = new DateFormatSymbols().getMonths()[mm];
        Log.d(TAG,"month name  "+monthName);

        // set current date into textview
       dateTextView.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(day).append(" , ").append(dd).append(" ").append(monthName).append(" ").append(yy).append(" :")
                );


        return view;
    }

    public void writeToDB(){

    }
}
