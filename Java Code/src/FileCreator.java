import java.io.*;

public class FileCreator {
    public static void createFile(String fileName){
        try{
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch (IOException e){
            System.out.println("An error has occurred");
        }
    }

    public static void fillFile(String input, String fileNamePath){
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
