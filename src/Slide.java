import java.util.ArrayList;
import java.util.List;

public class Slide {
    List<Photo> slide;
    List<String> tags_of_slide;
    public Slide(){
        slide = new ArrayList<>();
        tags_of_slide = new ArrayList<>();
    }

    public List<Photo> getSlide() {
        return slide;
    }

    public List<String> getTags_of_slide() {
        return tags_of_slide;
    }

    public void setTags_of_slide(List<String> tags_of_slide) {
        this.tags_of_slide = tags_of_slide;
    }

    public Slide placer(List<Photo> list){
        Slide slides = new Slide();
         int count =0;
         for(Photo a : list){
             if(a.getAligment().equals("H")){
                 slides.getSlide().add(a);
                 slides.setTags_of_slide(a.tegs);
                 return slides;
             }
             else{
                 slides.getSlide().add(a);
                 for(int i = count; i<list.size(); i++){
                     if(list.get(i).getAligment().equals("V") && a.tegs.contains(list.get(i).tegs)){
                         slides.getSlide().add(list.get(i));
                     }
                 }
                 return slides;
             }
             count++;
         }


     }
}
