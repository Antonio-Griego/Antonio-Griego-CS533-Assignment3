import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class implements a Java based benchmarking program based off
 * of the work of Martin Thoma.
 *
 * https://martin-thoma.com/matrix-multiplication-python-java-cpp/
 *
 * @author Antonio Griego
 */
public class JavaBenchmark {
    static Random rng = new Random();
    static ArrayList<ArrayList<Double>> A = new ArrayList<ArrayList<Double>>();
    static ArrayList<ArrayList<Double>> B = new ArrayList<ArrayList<Double>>();

    public static void fill() {
        //return min + (max - min) * rng.nextDouble();

        int n = A.size();
        Double max = 1.0;
        Double min = -1.0;

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                // Uniformly distributed over [-1, 1]
                A.get(j).set(k, (max - min) * rng.nextDouble());
                B.get(j).set(k, (max - min) * rng.nextDouble());
            }
        }
    }

    /**
     * This function implements DGEMM with loop indicies ordered for column major.
     */
    public static Double[][] dgemm_col(ArrayList<ArrayList<Double>> A, ArrayList<ArrayList<Double>> B) {
        int n = A.size();

        // initialise C
        Double[][] C = new Double[n][n];

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                Double tmp = B.get(k).get(j);
                for (int i = 0; i < n; i++) {
                    C[i][j] += A.get(i).get(k) * tmp;
                }
            }
        }

        return C;
    }

    /**
     * The benchmarking program which measures the speed in seconds of a
     * matrix multiplication of two 100 x 100 matrices and appends the output
     * to a file. It is intended that this program is run dozens, hundreds, or
     * thousands of times to produce a data set.
     */
    public static void main(String[] args) {
        fill();
        Double[][] C;

        // warm-up
        C = dgemm_col(A, B);

        // test matrix multiplication
        Double seconds = (double)System.nanoTime();
        C = dgemm_col(A, B);
        seconds = (System.nanoTime() - seconds) / 10_000.0;

        try {
            BufferedWriter out;
            out = new BufferedWriter(new FileWriter("results_java.out", true));
            out.write(seconds.toString() + ",\n");
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}