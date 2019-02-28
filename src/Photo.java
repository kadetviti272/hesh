import java.util.ArrayList;
import java.util.List;

public class Photo {
    String aligment;
    List<String> tegs;
    int count_of_tegs;

    public Photo(){
        tegs = new ArrayList<String>();

    }
    public int getCount_of_tegs() {
        return count_of_tegs;
    }

    public String getAligment() {
        return aligment;
    }



    public void setAligment(String aligment) {
        this.aligment = aligment;
    }

    public void setCount_of_tegs(int count_of_tegs) {
        this.count_of_tegs = count_of_tegs;
    }


}
