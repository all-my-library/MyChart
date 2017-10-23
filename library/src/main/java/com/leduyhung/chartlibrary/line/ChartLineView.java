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
    private boolean showCell, isShowCHart;
    private int axisColor, rulerColor, backgroundColor, lineValueColor;
    private int axisSize, axisValueSize, lineValueSize;

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

        if (isShowCHart)
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
            typedArray.recycle();
        }

        drawHelper = new DrawChartLineHelper();
        drawHelper.initPaintColor(axisColor, rulerColor, axisColor, lineValueColor, backgroundColor);
        drawHelper.initPainSize(axisSize, axisValueSize, lineValueSize);
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

        isShowCHart = true;
        invalidate();
    }
}