package leduyhung.view.mychart.line;

/**
 * Created by hungleduy on 10/18/17.
 */
class ChartLineData {

    static final String VALUE_X = "VALUE_X";
    static final String VALUE_Y = "VALUE_Y";

    private float aX, aY, aTextX, aTextY, cX, cY, valueX, valueY;

    public ChartLineData(float aTextX, float valueX, float valueY) {
        this.aTextX = aTextX;
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public ChartLineData(float aX, float aY, float aTextX, float aTextY, float valueX, float valueY) {
        this.aX = aX;
        this.aY = aY;
        this.aTextX = aTextX;
        this.aTextY = aTextY;
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public float getaX() {
        return aX;
    }

    public void setaX(float aX) {
        this.aX = aX;
    }

    public float getaY() {
        return aY;
    }

    public void setaY(float aY) {
        this.aY = aY;
    }

    public float getaTextX() {
        return aTextX;
    }

    public void setaTextX(float aTextX) {
        this.aTextX = aTextX;
    }

    public float getaTextY() {
        return aTextY;
    }

    public void setaTextY(float aTextY) {
        this.aTextY = aTextY;
    }

    public float getValueX() {
        return valueX;
    }

    public void setValueX(float valueX) {
        this.valueX = valueX;
    }

    public float getValueY() {
        return valueY;
    }

    public void setValueY(float valueY) {
        this.valueY = valueY;
    }

    public float getcX() {
        return cX;
    }

    public void setcX(float cX) {
        this.cX = cX;
    }

    public float getcY() {
        return cY;
    }

    public void setcY(float cY) {
        this.cY = cY;
    }
}