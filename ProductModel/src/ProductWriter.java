import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<String> ProductData = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean Cont = true;
        int i = 1;
        //Data Entry Loop
        do{
            String Data = "";
            String Name,Desc,ID;
            Double Price;
            ID = String.format("%06d", i);
            Name = SafeInput.getNonZeroLenString(in,"Please enter the name of the product");
            Desc = SafeInput.getNonZeroLenString(in,"Please enter the description of the product");
            Price = SafeInput.getDouble(in,"Please enter the price of the product");
            Data = String.join(", ", ID,Name, Desc, Double.toString(Price));
            ProductData.add(Data);
            Data = "";
            Cont = SafeInput.getYNConfirm(in,"Would you like to continue? (Y/N): ");
            i++;

        }while(Cont);

        //File Output
        String WorkingDir = System.getProperty("user.dir") + "/ProductModel/src";
        String OutputFile = SafeInput.getNonZeroLenString(in,"Please enter the output file without the extension") + ".txt";
        OutputFile = WorkingDir + File.separator + OutputFile;
        //Check if file exists
        try{
            File OutputToFile = new File(OutputFile);
            if(OutputToFile.createNewFile()){
                System.out.println("File Created");
            }
            else{
                System.out.println("Output file already exists");
            }
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
            System.out.println("an Error Occurred");
        }
        //write to file
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(OutputFile));
            for(int x = 0; x < ProductData.size(); x++){
                bw.write(ProductData.get(x));
                bw.newLine();
            }
            bw.close();
        }
        catch (
                IOException e){
            System.out.println(e);
        }
        //show what was written to file
        for(int x = 0; x < ProductData.size(); x++){
            System.out.println(ProductData.get(x));
        }
        System.out.println("Was Successfully Written");
    }
}
