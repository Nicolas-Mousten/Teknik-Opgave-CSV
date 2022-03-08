import java.io.File;
import java.io.IOException;

public class FileCreator {
    public static void createDDL(String structure, String fileName){
        try{
            File DDLFile = new File(fileName);
            if (DDLFile.createNewFile()) {
                System.out.println("File created: " + DDLFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e){

        }

        //Create the DDL file as a text File then input the String into the file
        //Then do the same with SQL Input.

    }
}
