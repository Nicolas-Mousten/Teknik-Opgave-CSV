import java.util.ArrayList;

public class RunCode {
    public static void main(String[] args) {
        TableStructure imdb = CSVReader.csvReader("Java Code/Resources/imdb-data.csv", ";");
        //System.out.println(imdb);
        String DDL = sqlDDL("imdb-data.csv",
                imdb.getTitle().get(0),
                imdb.getTitle().get(1),
                imdb.getTitle().get(2),
                imdb.getTitle().get(3),
                imdb.getTitle().get(4),
                imdb.getTitle().get(5));
        //System.out.println(DDL);
        FileCreator.createDDL("Java Code/src/SQL/DDL.sql");
        FileCreator.fillDDL(DDL,"Java Code/src/SQL/DDL.sql");
    }


    public static String sqlDDL(String fileName,String yearTitle, String lengthYear, String titleTitle, String subjectTitle, String popularityTitle, String awardsTitle){
        return  "CREATE TABLE "+ "`"+fileName+"`" +" (\n"+
                "`"+yearTitle+"`"+" Varchar(255),\n" +
                "`"+lengthYear+"`"+" Varchar(255),\n"+
                "`"+titleTitle+"`"+" Varchar(255),\n"+
                "`"+subjectTitle+"`"+" Varchar(255),\n"+
                "`"+popularityTitle+"`"+" Varchar(255),\n"+
                "`"+awardsTitle+"`"+" Varchar(255)\n"+
                ");";
    }
    public static String sqlDML(String fileName){
        return "INSERT INTO" + "`" +fileName+ "`" + "";
    }
}
