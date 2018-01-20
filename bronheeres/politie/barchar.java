package bronheeres.politie;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;


public class barchar extends Fragment {
    View myView;
    BarChart barChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.barchar, container, false);

        BarChart barChart = (BarChart) myView.findViewById(R.id.bargraph);

        int[] data = ReadCounter.getData();


       ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(data[0], 0));
        barEntries.add(new BarEntry(data[1], 1));
        barEntries.add(new BarEntry(data[2], 2));
        barEntries.add(new BarEntry(data[3], 3));
        BarDataSet barDataSet = new BarDataSet(barEntries, "keren geopend");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("Hoofdstuk 1");
        theDates.add("Hoofdstuk 2");
        theDates.add("Hoofdstuk 3");
        theDates.add("Hoofdstuk 4");

        BarData theData = new BarData(theDates, barDataSet);
        barChart.setData(theData);


        return myView;

    }

    }

