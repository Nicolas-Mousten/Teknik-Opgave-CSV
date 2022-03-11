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
        FileCreator.createFile("Java Code/src/SQL/DDL.sql");
        FileCreator.fillFile(DDL,"Java Code/src/SQL/DDL.sql");
        String DML = sqlDML("imdb-data.csv",
                imdb.getTitle().get(0),
                imdb.getTitle().get(1),
                imdb.getTitle().get(2),
                imdb.getTitle().get(3),
                imdb.getTitle().get(4),
                imdb.getTitle().get(5),
                imdb.getData());
        //System.out.println(DML);
        FileCreator.createFile("Java Code/src/SQL/DML.sql");
        FileCreator.fillFile(DML,"Java Code/src/SQL/DML.sql");
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
    public static String sqlDML(String fileName,String yearTitle, String lengthYear, String titleTitle, String subjectTitle, String popularityTitle, String awardsTitle, ArrayList<ImdbData> imdbList){
        String data = "";
        for (int i = 0; i < imdbList.size(); i++) {
            if(i < imdbList.size()-1) {
                String line = "(" + "\"" + imdbList.get(i).getYear() + "\"" + ", " + "\"" + imdbList.get(i).getLength() + "\"" + ", " + "\"" + imdbList.get(i).getTitle() + "\"" + ", " + "\"" + imdbList.get(i).getSubject() + "\"" + ", " + "\"" + imdbList.get(i).getPopularity() + "\"" + ", " + "\"" + imdbList.get(i).getAwards() + "\"" + "),\n";
                data += line;
            }else{
                String line = "(" + "\"" + imdbList.get(i).getYear() + "\"" + ", " + "\"" + imdbList.get(i).getLength() + "\"" + ", " + "\"" + imdbList.get(i).getTitle() + "\"" + ", " + "\"" + imdbList.get(i).getSubject() + "\"" + ", " + "\"" + imdbList.get(i).getPopularity() + "\"" + ", " + "\"" + imdbList.get(i).getAwards() + "\"" + ");";
                data += line;
            }
        }
        return "INSERT INTO " + "`" +fileName+ "`" + " ("+"`"+yearTitle+"`, `"+lengthYear+"`, `"+titleTitle+"`,\n"+
                "`"+subjectTitle+"`, `"+popularityTitle+"`, `"+awardsTitle+"`"+") VALUES\n" +
                data;
    }
}

