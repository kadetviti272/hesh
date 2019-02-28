import java.util.*;
import java.util.stream.Collectors;

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

    public static  int Max;
    public boolean isRightCheak;
    public boolean isLeftCheak;
    public int indexMax;
    public int[] rightCheakIndex;
    List<Photo> slide;
    List<String> tags_of_slide;
    int rightIndex;
    int leftIndex;

    public void setTags_of_slide(List<String> tags_of_slide) {
        this.tags_of_slide = tags_of_slide;
    }

    public List<Slide> placer(List<Photo> list){
        Slide slides;
        List<Slide>tempSlaid = new ArrayList<>();
        List<Photo> vertiaclPhoto =  new ArrayList<>( list.stream().filter( p -> p.aligment.equals("V")).collect(Collectors.toList()));
         int count =0;
         for(Photo a : list) {
             slides = new Slide();
             if (a.getAligment().equals("H")) {
                 slides.getSlide().add(a);
                 slides.setTags_of_slide(a.tegs);
                 tempSlaid.add(slides);
                 continue;
             }
             count++;
         }

        for (Photo photo: vertiaclPhoto) {
            int countTeg=0;
            //List<Photo> maibiDuo= new ArrayList<>();

            Map<Integer,Photo> maibiDuo = new LinkedHashMap<>();

            for (int i = 0; i <vertiaclPhoto.size() ; i++) {
                if(vertiaclPhoto.get(i).equals(photo)){
                    continue;
                }

                for (int j = 0; j < vertiaclPhoto.get(i).getTegs().size(); j++) {
                    for (int k = 0; k < photo.getTegs().size() ; k++) {
                        if(vertiaclPhoto.get(i).getTegs().get(j).equals(photo.getTegs().get(k))){
                            countTeg++;
                        }
                        if( j == vertiaclPhoto.get(i).getTegs().size()-1 && count==1 ){
                            maibiDuo.put(vertiaclPhoto.get(i).tegs.size(), vertiaclPhoto.get(i));
                        }
                    }
                }
            }

            if(maibiDuo.size() !=0){
                slides = new Slide();
                slides.getSlide().add(maibiDuo.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).findAny().get().getValue()) ;
                slides.getSlide().add(photo);

                for (int i = 0; i < slides.getSlide().get(1).getTegs().size() ; i++) {
                    slides.getSlide().get(0).getTegs().add(slides.getSlide().get(1).getTegs().get(i));
                }
                slides.setTags_of_slide(new ArrayList<String>(new HashSet<String>(slides.getSlide().get(0).getTegs()).toArraygit()) {
                });



            }else {
                continue;
            }
            return tempSlaid;
        }


        public int getTagCount() {
            return tags_of_slide.size();
        }

        public String GetTag(int index) {
            return tags_of_slide.get(index);
        }

        public boolean getTagContaints(String s) {
            for (int i = 0 ; i<tags_of_slide.size();i++)
                if(tags_of_slide.get(i).equals(s))
                    return true;
            return false;
        }
    }
}
