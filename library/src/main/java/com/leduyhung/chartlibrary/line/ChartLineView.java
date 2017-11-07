package com.leduyhung.chartlibrary.line;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.leduyhung.chartlibrary.R;

import java.util.List;

/**
 * Created by hungleduy on 10/18/17.
 */

public class ChartLineView extends View {

    private DrawChartLineHelper drawHelper;
    private boolean hasName;
    private int axisColor, rulerColor, backgroundColor, lineValueColor, nameColor;
    private int axisSize, axisValueSize, lineValueSize, nameSize;
    private String name;

    public ChartLineView(Context context) {
        super(context);
        getAttribute(context, null);
    }

    public ChartLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttribute(context, attrs);
    }

    public ChartLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttribute(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        drawHelper.setWidthHeightView(getWidth(), getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawHelper.startDrawChart(canvas);
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        drawHelper = null;
    }

    private void getAttribute(Context context, AttributeSet attrs) {

        if (attrs != null) {

            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ChartLineView);
            axisColor = typedArray.getColor(R.styleable.ChartLineView_chart_line_color_axis, 0);
            rulerColor = typedArray.getColor(R.styleable.ChartLineView_chart_line_color_ruler, 0);
            lineValueColor = typedArray.getColor(R.styleable.ChartLineView_chart_line_color_line_value, 0);
            backgroundColor = typedArray.getColor(R.styleable.ChartLineView_chart_line_color_background, context.getResources().getColor(R.color.color_transparent));
            axisSize = typedArray.getDimensionPixelSize(R.styleable.ChartLineView_chart_line_size_axis, 4);
            axisValueSize = typedArray.getDimensionPixelSize(R.styleable.ChartLineView_chart_line_size_axis_value, 15);
            lineValueSize = typedArray.getDimensionPixelSize(R.styleable.ChartLineView_chart_line_size_line_value, 3);
            name = typedArray.getString(R.styleable.ChartLineView_chart_line_name);
            nameColor = typedArray.getColor(R.styleable.ChartLineView_chart_line_color_name, 0);
            nameSize = typedArray.getDimensionPixelSize(R.styleable.ChartLineView_chart_line_size_name, 50);
            hasName = typedArray.getBoolean(R.styleable.ChartLineView_chart_line_has_name, false);
            typedArray.recycle();
        }

        drawHelper = new DrawChartLineHelper();
        drawHelper.setHasName(hasName);
        drawHelper.initPaintColor(axisColor, rulerColor, axisColor, lineValueColor, backgroundColor);
        drawHelper.initPainSize(axisSize, axisValueSize, lineValueSize);
        drawHelper.initNameSize(nameSize);
        drawHelper.initNameChart(name);
        drawHelper.initNameColor(nameColor);
    }

    /**
     * set data for chart
     *
     * @param valueX
     * @param valueY
     */
    public void setChartData(float valueX, float valueY) {

        drawHelper.setChartData(valueX, valueY);
    }

    /**
     * call to clear data
     */
    public void clearDataChart() {

        drawHelper.clearChartData();
    }

    public void showChartLine() {

        invalidate();
    }

    /**
     * call to change color chart
     *
     * @param colorAxis
     * @param colorRuler
     * @param colorLineValue
     * @param background
     */
    public void setColorChart(int colorAxis, int colorRuler, int colorLineValue, int background) {

        drawHelper.initPaintColor(colorAxis, colorRuler, colorAxis, colorLineValue, background);
        showChartLine();
    }

    /**
     * call to change size chart
     *
     * @param axisSize
     * @param axisValueSize
     * @param lineValueSize
     */
    public void setSizeChart(int axisSize, int axisValueSize, int lineValueSize) {

        drawHelper.initPainSize(axisSize, axisValueSize, lineValueSize);
        showChartLine();
    }

    /**
     * call to set name's chart
     *
     * @param name
     */
    public void setNameChart(String name) {

        this.name = name;
        drawHelper.initNameChart(name);
        invalidate();
    }

    /**
     * call to set name's color
     *
     * @param color
     */
    public void setNameChartColor(int color) {

        this.nameColor = color;
        drawHelper.initNameColor(nameColor);
        invalidate();
    }

    /**
     * call to set name's size
     *
     * @param size
     */
    public void setNameChartSize(int size) {

        this.nameSize = size;
        drawHelper.initNameSize(size);
        invalidate();
    }
}