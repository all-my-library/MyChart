package mychart.leduyhung.com.mychart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.leduyhung.chartlibrary.line.ChartLineView;

public class DemoActivity extends AppCompatActivity {

    ChartLineView chartLineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initChart();
    }

    private void initChart() {

        chartLineView = findViewById(R.id.chartlineview);
        chartLineView.setChartData(0, 1);
        chartLineView.setChartData(1, 6);
        chartLineView.setChartData(2, 3);
        chartLineView.setChartData(3, 5);
        chartLineView.setChartData(4, 7);
        chartLineView.setChartData(5, 2);
        chartLineView.setChartData(6, 9);
        chartLineView.setChartData(7, 4);
        chartLineView.setChartData(8, 6);
        chartLineView.setChartData(9, 3);
        chartLineView.showChartLine();
        chartLineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chartLineView.clearDataChart();
                chartLineView.setChartData(1, 9);
                chartLineView.setChartData(2, 100);
                chartLineView.setChartData(3, 34);
                chartLineView.setChartData(4, 53);
                chartLineView.setChartData(5, 1);
                chartLineView.setChartData(6, 90);
                chartLineView.setChartData(7, 23);
                chartLineView.setChartData(8, 44);
                chartLineView.setChartData(9, 80);
                chartLineView.setChartData(10, 40);
                chartLineView.setColorChart(getResources().getColor(R.color.color_white), getResources().getColor(R.color.color_white),getResources().getColor(R.color.color_white), getResources().getColor(R.color.color_transparent));
            }
        });
    }
}