public class Circle {
    private String cx;
    private String cy;
    private String r;
    private String stroke;
    private String strokeWidth;
    private String fill;

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getCy() {
        return cy;
    }

    public void setCy(String cy) {
        this.cy = cy;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(String strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public Circle(String cx, String cy, String r, String stroke, String strokeWidth, String fill) {
        setCx(cx);
        setCy(cy);
        setR(r);
        setStroke(stroke);
        setStrokeWidth(strokeWidth);
        setFill(fill);
    }

    @Override
    public String toString() {
        return "Circle: " + "cx="+getCx()+"; cy"+getCy()+"; r="+getR()+"; stroke=" + getStroke()+"; strokeWidth="+getStrokeWidth()+"; fill="+getFill();
    }
}
