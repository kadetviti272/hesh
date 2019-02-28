import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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


    public List<String> getTegs() {
        return tegs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return count_of_tegs == photo.count_of_tegs &&
                index_photo == photo.index_photo &&
                Objects.equals(aligment, photo.aligment) &&
                Objects.equals(tegs, photo.tegs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aligment, tegs, count_of_tegs, index_photo);
    }
}
