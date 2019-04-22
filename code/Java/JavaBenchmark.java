import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

/**
 * This class implements a Java based benchmarking program based off
 * of the work of Martin Thoma.
 *
 * https://martin-thoma.com/matrix-multiplication-python-java-cpp/
 *
 * @author Antonio Griego
 */
public class JavaBenchmark {
    static File matrixInputFile = new File("100.in");
    static ArrayList<ArrayList<Double>> A = new ArrayList<ArrayList<Double>>();
    static ArrayList<ArrayList<Double>> B = new ArrayList<ArrayList<Double>>();

    public static void readMatrixInputFile() {
        String thisLine;

        try {
            BufferedReader br = new BufferedReader(new FileReader(matrixInputFile));

            // Begin reading A
            while ((thisLine = br.readLine()) != null) {
                if (thisLine.trim().equals("")) {
                    break;
                } else {
                    ArrayList<Double> line = new ArrayList<Double>();
                    String[] lineArray = thisLine.split("\t");
                    for (String number : lineArray) {
                        line.add(Double.parseDouble(number));
                    }
                    A.add(line);
                }
            }

            // Begin reading B
            while ((thisLine = br.readLine()) != null) {
                ArrayList<Double> line = new ArrayList<Double>();
                String[] lineArray = thisLine.split("\t");
                for (String number : lineArray) {
                    line.add(Double.parseDouble(number));
                }
                B.add(line);
            }
e
            br.close();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }

    public static int[][] ikjAlgorithm(ArrayList<ArrayList<Double>> A, ArrayList<ArrayList<Double>> B) {
        int n = A.size();

        // initialise C
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] += A.get(i).get(k) * B.get(k).get(j);
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {

        readMatrixInputFile();

        int[][] C = ikjAlgorithm(A, B);

        System.out.println("Hello, Java Benchmark world!");
    }
}