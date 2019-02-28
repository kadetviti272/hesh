import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String ... args) throws IOException {
    // parser("d:/c_memorable_moments.txt").stream().forEach(System.out::println);
    }
    public static List<Photo> parser(String vay) throws IOException {
        List<Photo> res = new ArrayList<Photo>();
        FileReader fileReader = new FileReader(vay);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        for(String a : lines){
            String [] photo = a.split(" ");
            Photo temp = new Photo();
            temp.setAligment(photo[0]);
            temp.setCount_of_tegs(Integer.parseInt(photo[1]));
            for(int i =2; i<Integer.parseInt(photo[1]);i++){
                temp.tegs.add(photo[i]);

        }
        temp.setIndex_photo(res.size());
        res.add(temp);


        }
        return res;
    }

    public static List<Slide> Sort( List<Slide> body) {
        int countGood = 0;
        boolean isChange = true;
        int connections = body.size();
        List<Slide> res = new ArrayList<>();
        while (isChange&connections!=1)
        {
            isChange = false;
            for (int i = 0; i < body.size() - 1; i++) {
                if (!body.get(i).isRightCheak) {
                    for (int j = i + 1; j < body.size(); j++) {
                        if (!body.get(j).isLeftCheak & body.get(i).Max < Formyla(body.get(i), body.get(j))) {
                            body.get(i).Max = Formyla(body.get(i), body.get(j));
                            body.get(i).indexMax = j;
                        }
                    }
                } else if (!body.get(i).isLeftCheak) {
                    for (int j = i + 1; j < body.size(); j++) {
                        if (!body.get(j).isRightCheak & body.get(i).Max < Formyla(body.get(i), body.get(j))) {
                            body.get(i).Max = Formyla(body.get(i), body.get(j));
                            body.get(i).indexMax = j;
                        }
                    }
                }
            }


            List<Slide> sortedTmp = body.stream().sorted(Comparator.comparingInt(a -> a.Max)).collect(Collectors.toList());

            for (int i = sortedTmp.size() - 1; i >= 0; i--) {
                if (!sortedTmp.get(i).isRightCheak & !body.get(sortedTmp.get(i).indexMax).isLeftCheak) {
                    sortedTmp.get(i).isRightCheak = true;
                    body.get(sortedTmp.get(i).indexMax).isLeftCheak = true;
                    sortedTmp.get(i).rightIndex = sortedTmp.get(i).indexMax;

                    body.get(sortedTmp.get(i).indexMax).leftIndex = body.indexOf(sortedTmp.get(i));
                    connections--;
                    isChange = true;
                } else if (!body.get(i).isLeftCheak & !body.get(sortedTmp.get(i).indexMax).isRightCheak) {
                    sortedTmp.get(i).isLeftCheak = true;
                    body.get(sortedTmp.get(i).indexMax).isRightCheak = true;
                    sortedTmp.get(i).leftIndex= sortedTmp.get(i).indexMax;

                    body.get(sortedTmp.get(i).indexMax).rightIndex = body.indexOf(sortedTmp.get(i));
                    connections--;
                    isChange = true;
                }

            }
            int prewInd = 0;
            for (int i =0; i<body.size();i++)
            {
                if(!body.get(i).isLeftCheak) {
                    res.add(body.get(i));
                    prewInd = i;
                    break;
                }


            }

            for (int i =0;i<body.size()-1;i++)
            {
                if(body.get(prewInd).rightIndex!=-1) {
                    res.add(body.get(body.get(prewInd).rightIndex));
                    prewInd = body.get(prewInd).rightIndex;
                }
                else {

                }
            }

        }
        return res;
    }
}
