package com.leduyhung.chartlibrary.line;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungleduy on 10/18/17.
 */
class DrawChartLineHelper {

    private Paint paintAxis, paintRuler, paintAxisValue, paintLineValue, paintBackground;
    private RectF rectFAxisX, rectFAxisY, rectFRulerX, rectFRulerY, rectFBackground;
    private Rect boundText;

    private List<ChartLineData> chartData;
    private int lengthData;
    private int axisSize, rulerSize;
    private int widthView, heightView, axisX, axisY, spaceForTitle;
    private int spaceAxis;
    private float maxAxisValueX, maxDataX, maxAxisValueY, maxDataY;

    public DrawChartLineHelper() {

        boundText = new Rect();
        paintAxis = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRuler = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintAxisValue = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintAxisValue.setTextAlign(Paint.Align.LEFT);
        paintLineValue = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectFAxisX = new RectF();
        rectFAxisY = new RectF();
        rectFRulerX = new RectF();
        rectFRulerY = new RectF();
        rectFBackground = new RectF();
        chartData = new ArrayList<>();
        spaceAxis = 80;
        rulerSize = 2;
    }

    private float getMaxValueIntoChartData(String field) {

        float value = 0f;
        switch (field) {

            case ChartLineData.VALUE_X:

                for (int i = 0; i < lengthData; i++) {

                    if (chartData.get(i).getValueX() > value) {
                        value = chartData.get(i).getaTextX();
                    }
                }
                break;
            case ChartLineData.VALUE_Y:
                for (int i = 0; i < lengthData; i++) {

                    if (chartData.get(i).getValueY() > value) {
                        value = chartData.get(i).getValueY();
                    }
                }
                break;
        }
        return value;
    }

    private void calculatorChartData() {

        chartData.get(0).setaTextY(0);
        chartData.get(0).setaX(spaceAxis);
        chartData.get(0).setaY(heightView - spaceAxis);
        chartData.get(0).setcY(convertData(chartData.get(0).getValueY()) + spaceForTitle + (spaceAxis / 3));

        for (int i = 1; i < lengthData; i++) {

            chartData.get(i).setaX(((axisX * i) / (lengthData - 1)) + spaceAxis);

            if (i < 8) {

                chartData.get(i).setaTextY((maxDataY * i) / 6);
                chartData.get(i).setaY((((axisY - spaceForTitle) * (6 - i)) / 6) + spaceForTitle + (spaceAxis / 3));
            }

            chartData.get(i).setcY(convertData(chartData.get(i).getValueY()) + spaceForTitle + (spaceAxis / 3));
        }
    }

    private float convertData(float dataY) {

        float maxY = axisY - spaceForTitle;
        float a = maxY / 2;
        float dataReturn = dataY * maxY / maxDataY;
        if (dataReturn > a) {
            return dataReturn - ((dataReturn - a) * 2);
        } else if (dataReturn < a) {
            return dataReturn + ((a - dataReturn) * 2);
        } else {

            return dataReturn;
        }
    }

    private void drawBackground(Canvas canvas) {

        canvas.drawRect(rectFBackground, paintBackground);
    }

    private void drawAxis(Canvas canvas) {

        rectFAxisX.set(spaceAxis, heightView - spaceAxis, axisX + spaceAxis, heightView - spaceAxis + axisSize);
        rectFAxisY.set(spaceAxis - axisSize, spaceAxis / 3, spaceAxis, (spaceAxis / 3) + axisY + axisSize);
        canvas.drawRect(rectFAxisX, paintAxis);
        canvas.drawRect(rectFAxisY, paintAxis);
    }

    private void drawDataChart(Canvas canvas) {

        paintAxisValue.getTextBounds(chartData.get(0).getaTextY() + "", 0, (chartData.get(0).getaTextY() + "").length(), boundText);
        canvas.drawText(chartData.get(0).getaTextX() + "", chartData.get(0).getaX() - (boundText.width() / 2), heightView - (spaceAxis / 2), paintAxisValue);
        canvas.drawText(chartData.get(0).getaTextY() + "", spaceAxis / 2, chartData.get(0).getaY() + (boundText.height() / 2), paintAxisValue);
        for (int i = 1; i < lengthData; i++) {

            paintAxisValue.getTextBounds(chartData.get(i).getaTextX() + "", 0, (chartData.get(i).getaTextX() + "").length(), boundText);
            rectFRulerY.set(chartData.get(i).getaX() - rulerSize, chartData.get(7).getaY(), chartData.get(i).getaX(), heightView - spaceAxis);
            canvas.drawText(chartData.get(i).getaTextX() + "", chartData.get(i).getaX() - (boundText.width() / 2), heightView - (spaceAxis / 2), paintAxisValue);
            if (i < 8) {

                rectFRulerX.set(spaceAxis, chartData.get(i).getaY(), spaceAxis + axisX, chartData.get(i).getaY() + rulerSize);
                canvas.drawRect(rectFRulerX, paintRuler);
                canvas.drawText(chartData.get(i).getaTextY() + "", spaceAxis / 3, chartData.get(i).getaY() + (boundText.height() / 2), paintAxisValue);
            }
            canvas.drawRect(rectFRulerY, paintRuler);
            canvas.drawLine(chartData.get(i - 1).getaX() - (rulerSize / 2), chartData.get(i - 1).getcY(), chartData.get(i).getaX() - (rulerSize / 2), chartData.get(i).getcY(), paintLineValue);
            canvas.drawCircle(chartData.get(i).getaX() - (rulerSize / 2), chartData.get(i).getcY(), 3, paintLineValue);
        }
    }

    void setWidthHeightView(int width, int height) {

        widthView = width;
        heightView = height;
        axisX = width - (spaceAxis + (spaceAxis / 3));
        axisY = height - (spaceAxis + (spaceAxis / 3));
        spaceForTitle = (13 * axisY / 30);
        rectFBackground.set(0, 0, widthView, heightView);
    }

    void initPaintColor(int... color) {

        paintAxis.setColor(color[0]);
        paintRuler.setColor(color[1]);
        paintAxisValue.setColor(color[2]);
        paintLineValue.setColor(color[3]);
        paintBackground.setColor(color[4]);
    }

    void initPainSize(int... size) {

        axisSize = size[0];
        paintAxisValue.setTextSize(size[1]);
        paintAxisValue.setStrokeWidth(size[2]);
    }

    void setChartData(float valueX, float valueY) {

        chartData.add(new ChartLineData(valueX, valueX, valueY));
    }

    void clearChartData() {

        if (chartData != null)
            chartData.clear();
    }

    void startDrawChart(Canvas canvas) {

        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.ADD);
        if (chartData != null && chartData.size() > 0) {
            try {

                lengthData = chartData.size();
                maxAxisValueX = getMaxValueIntoChartData(ChartLineData.VALUE_X);
                maxDataY = getMaxValueIntoChartData(ChartLineData.VALUE_Y);
                calculatorChartData();

            } catch (Exception e) {

                Log.e("ChartLineView", "drawChart: -> chart data is null. \n\r" + e.toString());
            } finally {

                drawBackground(canvas);
                drawAxis(canvas);
                drawDataChart(canvas);
            }
        }
    }
}