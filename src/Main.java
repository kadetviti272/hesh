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
        res.add(temp);


        }
        return res;
    }
}
