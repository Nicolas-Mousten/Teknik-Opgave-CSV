import java.util.ArrayList;

public class RunCode {
    public static void main(String[] args) {
        TableStructure imdb = CSVReader.csvReader("Java Code/Resources/imdb-data.csv", ";");
        System.out.println(imdb);
        String DDL = sqlCommit("Java Code/Resources/imdb-data.csv",
                imdb.getTitle().get(0),
                imdb.getTitle().get(1),
                imdb.getTitle().get(2),
                imdb.getTitle().get(3),
                imdb.getTitle().get(4),
                imdb.getTitle().get(5));
        System.out.println(DDL);
        FileCreator.createDDL(DDL,"Java Code/SQL/DDL.sql");

    }


    public static String sqlCommit(String fileName,String yearTitle, String lengthYear, String titleTitle, String subjectTitle, String popularityTitle, String awardsTitle){
        return  "CREATE TABLE "+ fileName +" {"+
                yearTitle+" Varchar(255)," +
                lengthYear+" Varchar(255),"+
                titleTitle+" Varchar(255),"+
                subjectTitle+" Varchar(255),"+
                popularityTitle+" Varchar(255),"+
                awardsTitle+" Varchar(255)"+
                "}";
    }
}
