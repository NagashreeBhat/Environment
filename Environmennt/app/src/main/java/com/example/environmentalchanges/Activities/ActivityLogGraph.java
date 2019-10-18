//package com.example.environmentalchanges.Activities;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Color;
//import android.os.Bundle;
//
//import com.example.environmentalchanges.R;
//import com.github.mikephil.charting.charts.PieChart;
//import com.github.mikephil.charting.data.PieData;
//import com.github.mikephil.charting.data.PieDataSet;
//import com.github.mikephil.charting.data.PieEntry;
//import com.github.mikephil.charting.utils.ColorTemplate;
//
//import java.util.ArrayList;
//
//public class ActivityLogGraph extends AppCompatActivity {
//
//    PieChart pieChart;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_log_graph);
//
//        pieChart = (PieChart) findViewById(R.id.piechart);
//
//        pieChart.setUsePercentValues(true);
//        pieChart.getDescription().setEnabled(false);
//        pieChart.setExtraOffsets(5, 10, 5, 5);
//        pieChart.setDragDecelerationFrictionCoef(0.99f);
//
//        pieChart.setDrawHoleEnabled(true);
//        pieChart.setHoleColor(Color.WHITE);
//        pieChart.setTransparentCircleRadius(61f);
//
//        ArrayList<PieEntry> yValue = new ArrayList<>();
//        yValue.add(new PieEntry(34f, "Water Usage"));
//        yValue.add(new PieEntry(24f, "Electricity Usage"));
//        yValue.add(new PieEntry(14f, "Carbon Footprint"));
//        yValue.add(new PieEntry(04f, "Plastic Usage"));
//        yValue.add(new PieEntry(24f, "Sustainability"));
//        yValue.add(new PieEntry(54f, "Habits"));
//
//
//        PieDataSet dataSet = new PieDataSet(yValue, "Footprint");
//        dataSet.setSliceSpace(3f);
//        dataSet.setSelectionShift(5f);
//        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
//
//
//        PieData data = new PieData(dataSet);
//        data.setValueTextSize(10f);
//        data.setValueTextColor(Color.YELLOW);
//
//        pieChart.setData(data);
//
//    }
//}
