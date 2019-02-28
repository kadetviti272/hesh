import java.util.ArrayList;
import java.util.List;

public class Slide {
    List<Photo> slide;
    public Slide(){
        slide = new ArrayList<>();
    }
     public Slide placer(List<Photo> list){
         int count =0;
         for(Photo a : list){
             if(a.getAligment().equals("H")){
                 slide.add(a);
             }
             else{
                 slide.add(a);
                 for(int i = count; i<list.size(); i++){
                     if(list.get(i).getAligment().equals("V") && a.tegs.contains(list.get(i).tegs)){
                         slide.add(list.get(i));
                     }
                 }

             }
             count++;
         }
     }
}
