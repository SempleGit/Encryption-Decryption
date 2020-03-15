package encryptdecrypt;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = "";
        String out = "";
        String alg = "shift";

        for (int i = 0; i < args.length - 1; i += 2) {
            input = args[i];
            switch(input) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }

        Decryptor algMethod = AlgMake.make(alg);

        if (data.equals("") && !in.equals("")) {
            File inFile = new File(in);
            try (Scanner inScan = new Scanner(inFile)) {
                while (inScan.hasNext()) {
                    data = inScan.nextLine();
                }
            } catch (Exception E) {
                System.out.println("File error");
            }
        }

        char[] message = data.toCharArray();

        if (out.equals("")) {
            algMethod.transform(message, key, mode);
        } else {
            try (PrintWriter printWriter = new PrintWriter(out)) {
                printWriter.println(algMethod.transform(message, key, mode));
            } catch (Exception e) {
                System.out.println("error writing to file");
            }
        }

    }





}

