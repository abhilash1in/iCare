package com.abhilash1in.icare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrevEntryFragment extends Fragment {


    public PrevEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] days = { "Saturday", "Friday", "Thursday", "Wednesday", "Tuesday", "Monday", "Sunday"};
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prev_entry, container, false);
        // The adapter is initialised with department names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.single_entry, days);

        // Adapter mapped to listView
        final ListView listView = (ListView) view.findViewById(R.id.prev_entry_list);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                TextView tv = (TextView)view;
                String date = tv.getText().toString();
                Intent intent2 = new Intent();
                intent2.setClass(getContext(), ViewEntryActivity.class);
                intent2.putExtra("date", date);
                startActivity(intent2);
            }
        });

        listView.setAdapter(adapter);
        return view;
    }
}
