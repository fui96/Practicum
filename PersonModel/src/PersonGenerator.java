import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.*;
public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> PersonData = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean Cont = true;
        int i = 1;
        //Main Data Entry Loop
        do {
            //Data Collection
            String Data = "";
            String first, last, id, Title, YOB;
            id = String.format("%06d",i);
            first = SafeInput.getNonZeroLenString(in,"Please enter the first name");
            last = SafeInput.getNonZeroLenString(in,"Please enter the last name");
            Title = SafeInput.getNonZeroLenString(in,"Please enter your title");
            YOB = Integer.toString(SafeInput.getInt(in,"Please enter the year you were born"));
            YOB = String.format("%04d",Integer.parseInt(YOB));
            //Add to Array
            Data = String.join(", ", id,first,last,Title,YOB);
            PersonData.add(Data);
            Data = "";
            i += 1;
            Cont = SafeInput.getYNConfirm(in,"Do you want to continue? (Y/N)");
        }while(Cont);
        //Write output to file
        String Workingdir = System.getProperty("user.dir") + "/src";
        String OutputFile = SafeInput.getNonZeroLenString(in,"Please enter the output file name without file extension") + ".txt";
        OutputFile = Workingdir + File.separator + OutputFile;
        try {
            File OutputToFile = new File(OutputFile);
            if (OutputToFile.createNewFile()) {
                System.out.println("Output file created");
            } else {
                System.out.println("Output file already exists");
            }
        }
        catch(Exception e){
                System.out.println("Output file not created");
            }
        File OutputToFile = new File(OutputFile);
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(OutputToFile,true));
            for(int e = 0; e < PersonData.size(); e++){
                bw.write(PersonData.get(e));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("an error occurred");
        }
        for(int z = 0; z < PersonData.size(); z++){
            System.out.println(PersonData.get(z));
        }
    }
}
