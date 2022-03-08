import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static TableStructure csvReader(String file, String delimiter){
        File imdb = new File(file);
        ArrayList<String> columnTitles = new ArrayList<>();
        ArrayList<ImdbData> imdbArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(imdb);
            int count = 0;
            while(scanner.hasNextLine()){
                if(count <1){
                    String line = scanner.nextLine();
                    String[] stringsInArray = line.split(delimiter);
                    columnTitles.add(stringsInArray[0]);
                    columnTitles.add(stringsInArray[1]);
                    columnTitles.add(stringsInArray[2]);
                    columnTitles.add(stringsInArray[3]);
                    columnTitles.add(stringsInArray[4]);
                    columnTitles.add(stringsInArray[5]);
                }
                else if(count >= 1) {
                    String line = scanner.nextLine();
                    String[] stringsInArray = line.split(delimiter);
                    int year = Integer.parseInt(stringsInArray[0]);
                    int length = Integer.parseInt(stringsInArray[1]);
                    String title = stringsInArray[2];
                    String subject = stringsInArray[3];
                    int popularity = Integer.parseInt(stringsInArray[4]);
                    String awards = stringsInArray[5];
                    ImdbData currentImdb = new ImdbData(year, length, title, subject, popularity, awards);
                    imdbArrayList.add(currentImdb);
                }
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        TableStructure Table = new TableStructure(columnTitles,imdbArrayList);
        return Table;
    }
}
