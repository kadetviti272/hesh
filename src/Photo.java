import java.util.ArrayList;
import java.util.List;

public class Photo {
    String aligment;
    List<String> tegs;
    int count_of_tegs;
    int index_photo;

    public Photo(){
        tegs = new ArrayList<String>();

    }

    public int getIndex_photo() {
        return index_photo;
    }

    public void setTegs(List<String> tegs) {
        this.tegs = tegs;
    }

    public void setIndex_photo(int index_photo) {
        this.index_photo = index_photo;
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
