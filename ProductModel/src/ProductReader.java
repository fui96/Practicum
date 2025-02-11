import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        File selectedFile;
        ArrayList<String[]> Entries = new ArrayList<>();
        try{
            File WorkingDir = new File(System.getProperty("user.dir") + "/ProductModel/src");
            fileChooser.setCurrentDirectory(WorkingDir);
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = fileChooser.getSelectedFile();
                Path file =selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file));
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                SafeInput.prettyHeader("ID#       Name     Description               Price ");
                System.out.println();
                while (br.ready()){
                    String row = br.readLine();
                    String[] rowData = row.split(",");
                    Entries.add(rowData);
                }
                br.close();
                for( String[] entry : Entries){
                    // ID Name Desc Price
                    System.out.printf("%10s %10s %-24s %8s%n",entry[0],entry[1],entry[2],entry[3]);
                }

            }
            else{
                System.out.println("File not selected \nRun the program again and select a file");
            }
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }
}
