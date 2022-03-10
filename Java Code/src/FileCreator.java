import java.io.*;

public class FileCreator {
    public static void createDDL(String fileName){
        try{
            File DDLFile = new File(fileName);
            if (DDLFile.createNewFile()) {
                System.out.println("File created: " + DDLFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e){
            System.out.println("An error has occurred");
        }
    }

    public static void fillDDL(String input, String fileNamePath){
        try(FileWriter fw = new FileWriter(fileNamePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(input);
            System.out.println("Wrote to file");
        } catch (IOException e) {
            System.out.println("Failed to write to file");
        }
    }

    //Create the DDL file as a text File then input the String into the file
    //Then do the same with SQL Input.
}
