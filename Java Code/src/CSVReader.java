import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static ArrayList<ImdbData> csvReader(){
        File imdb = new File("Resources/imdb-data.csv");
        ArrayList<ImdbData> imdbArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(imdb);
            int count = 0;
            while(scanner.hasNextLine()){
                if(count >= 1) {
                    String line = scanner.nextLine();
                    String[] stringsInArray = line.split(";");
                    int year = Integer.parseInt(stringsInArray[0]);
                    int length = Integer.parseInt(stringsInArray[1]);
                    String title = stringsInArray[2];
                    String subject = stringsInArray[3];
                    int popularity = Integer.parseInt(stringsInArray[4]);
                    String awards = stringsInArray[5];
                    ImdbData currentImdb = new ImdbData(year, length, title, subject, popularity, awards);
                    imdbArrayList.add(currentImdb);
                }
                else{
                    scanner.nextLine();
                }
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return imdbArrayList;
    }
}
