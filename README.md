# VERSION JAR
Link file JAR: <a href="https://github.com/all-my-library/MyChart/tree/master/library/myjar_v1" title="">ChartLibrary v1</a>
# HOW TO USE
<h3>ChartLineView</h3>
<img src="https://github.com/all-my-library/MyChart/blob/master/art/line_chart.png"></a>
<p><b>1: Declare in xml</b></p>
<pre> com.leduyhung.chartlibrary.line.ChartLineView
        android:id="@+id/chartlineview"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        custom:chart_line_color_background="@color/color_transparent"
        custom:chart_line_color_axis="#FFFFFF"
        custom:chart_line_color_line_value="#FFFFFF"
        custom:chart_line_color_ruler="#37ffffff"
        custom:chart_line_size_axis="2dp"
        custom:chart_line_size_axis_value="10sp"
        custom:chart_line_size_line_value="1dp"
        custom:chart_line_name="Biểu đồ tiền lương"
        custom:chart_line_color_name="@color/color_white"
        custom:chart_line_size_name="18sp"
</pre>
<br/>
<p><b>2: Call to add data and show chart</b></p>
<pre>
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
    }
</pre>
<p><b>You can change your chart color or axis size like this</b></p>
<pre>
chartLineView.setColorChart(getResources().getColor(R.color.color_white),
getResources().getColor(R.color.color_white),
getResources().getColor(R.color.color_white),
getResources().getColor(R.color.color_transparent));
</pre>

<pre>
chartLineView.setSizeChart(40,40,40);   (axisSize, axisValue, lineValueSize)
</pre>

<p><b>Set title of the chart</b></p>
<pre>
chartLineView.setNameChart("Biểu đồ lương");
</pre>

<pre>
chartLineView.setNameChartColor(getResources().getColor(R.color.color_white));
</pre>

<pre>
chartLineView.setNameChartSize(30);
</pre>

<p><b>3: Create new data and show the chart, you need to call clearDataChart(), and then do follow step 2</b></p>
<pre>
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
                chartLineView.showChartLine();
</pre>
