import java.lang.Math;
import java.util.*;

class PerAlgo {
    public static void main(String args[]) {
        int n, i, j, ml, k;
        double thee = 1, eeta = 0.5, z = 0;
        System.out.println("Enter number of inputs:");
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        int row = (int) Math.pow(2, n);
        int A[][] = new int[row][n + 1];
        double w[] = new double[n];
        System.out.println("Enter weights");
        for (i = 0; i < n; ++i)
            w[i] = obj.nextDouble();
        System.out.println("Enter the truth table");
        for (i = 0; i < row; i++)
            for (j = 0; j < n + 1; j++)
                A[i][j] = obj.nextInt();
        for (k = 0; k < row; k++) {
            z = 0;
            for (i = 0; i < n; i++)
                z = z + w[i] * A[k][i];

            if (A[k][n] == 0) {

                if (z >= thee) {
                    if (A[k][n] == 0)
                        ml = 1;
                    else
                        ml = 0;
                    for (int l = 0; l < n; l++) {
                        w[l] = w[l] + eeta * (A[k][n] - ml) * A[k][l];
                    }
                    k = 0;
                }
            } else {
                if (z < thee) {
                    if (A[k][n] == 0)
                        ml = 1;
                    else
                        ml = 0;
                    for (int l = 0; l < n; l++) {
                        double wz = eeta * ((A[k][n] - ml) * A[k][l]);
                        w[l] = w[l] + wz;
                    }
                    k = 0;
                }
            }
        }
        for (i = 0; i < n; i++)
            System.out.println("Weights" + i + "==" + w[i]);

    }
}