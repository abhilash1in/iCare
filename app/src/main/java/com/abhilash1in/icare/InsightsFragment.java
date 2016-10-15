package com.abhilash1in.icare;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.NumberFormat;


public class InsightsFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.insights, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_insights, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Today's Entry");

        GraphView graph = (GraphView) view.findViewById(R.id.graph);

        graph.setTitle("Insights of Past Week");
        graph.setTitleTextSize(40);
        graph.setTitleColor(Color.BLACK);

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(0);
        nf.setMinimumIntegerDigits(1);

        NumberFormat nf2 = NumberFormat.getInstance();
        nf2.setMinimumFractionDigits(1);
        nf2.setMinimumIntegerDigits(1);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf, nf2));

        graph.getGridLabelRenderer().setHorizontalAxisTitle("Daily Values");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Percentage of Emotion");
        graph.getGridLabelRenderer().setNumVerticalLabels(6);
        graph.getGridLabelRenderer().setNumHorizontalLabels(8);
        graph.getGridLabelRenderer().setPadding(5);

        /*graph.getViewport().setScrollable(true); // enables horizontal scrolling
        graph.getViewport().setScrollableY(true); // enables vertical scrolling
        graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
        graph.getViewport().setScalableY(true); // en*/

        graph.getViewport().setMaxX(8);
        graph.getViewport().setMinX(1);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMaxY(1);
        graph.getViewport().setMinY(0);
        graph.getViewport().setYAxisBoundsManual(true);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 0.2),
                new DataPoint(2, 0.35),
                new DataPoint(3, 0.7),
                new DataPoint(4, 0.4),
                new DataPoint(5, 0.9),
                new DataPoint(6, 0.6),
                new DataPoint(7, 0.1)
        });
        series.setTitle("Anger");
        series.setColor(Color.RED);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(6);
        series.setThickness(4);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 0.5),
                new DataPoint(2, 0.23),
                new DataPoint(3, 0.56),
                new DataPoint(4, 0.47),
                new DataPoint(5, 0.78),
                new DataPoint(6, 0.38),
                new DataPoint(7, 0.54)
        });
        series2.setTitle("Happiness");
        series2.setColor(Color.BLUE);
        series2.setDrawDataPoints(true);
        series2.setDataPointsRadius(6);
        series2.setThickness(4);

        graph.addSeries(series2);

        graph.addSeries(series);

        return view;
    }

}


