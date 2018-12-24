import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StreetData {
    String name;
    List<String> highways;

    public StreetData(String name, String highway) {
        this.name = name;
        this.highways = new ArrayList<String>();
        highways.add(highway);
    }

    void addHighway(String highway) {
        if (highway != null) {
            this.highways.add(highway);
        } else {
            System.out.println("пустое значение highway");
        }
    }

}

