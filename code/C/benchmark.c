/**
 * This C program implements a benchmark based off of the code provided to us
 * by Prof. Matthew Fricke for CS 533 Assignment 3.
 *
 * https://github.com/gmfricke/CS533_Assignment3_Matmult
 *
 * @author Antonio Griego
 */

#include <stdlib.h>		// For: exit, drand48, malloc, free, NULL, EXIT_FAILURE
#include <stdio.h>		// For: perror
#include <string.h>		// For: memset
#include <sys/time.h>	// For struct timeval, gettimeofday

/**
 * This function implements DGEMM with loop indicies ordered for column major.
 */
void dgemm_col(int N, double A[N][N], double B[N][N], double C[N][N])
{
		int i, j, k;

		for (k = 0; k < N; k++) {
				for (j = 0; j < N; j ++) {
						double tmp = B[k][j];
						for (i = 0; i < N; i++) {
								C[i][j] += A[i][k] * tmp;
						}
				}
		}
}

/**
 * This function uses the C standard libraries to get the current wall time.
 */
double wall_time()
{
		struct timeval t;
		gettimeofday(&t, NULL);
		return 1. * t.tv_sec + 1.e-5 * t.tv_usec;
}

/**
 * This function fills a sqrt(n) x sqrt(n) matrix with random values.
 */
void fill(double *p, int n) {
		for (int i = 0; i < n; ++i) {
				// uniformly distributed over [-1, 1]
				p[i] = 2 * drand48() - 1;
		}
}

/**
 * The benchmarking program which measures the speed in seconds of a matrix
 * multiplication of two 100 x 100 matrices and appends the output to a file.
 * It is intended that this program is run dozens, hundreds, or thousands of
 * times to produce a data set.
 */
int main(int argc, char **argv) {
		int nmax = 100;
		FILE *outfile = fopen("results_c.out", "a");

		/* allocate memory */
		double *buf = (double *)malloc(3 * nmax * nmax * sizeof(double));

		/* Create and fill 3 random matrices A, B, C */
		double *A = buf + 0;
		double *B = A + nmax * nmax;
		double *C = B + nmax * nmax;
		fill(A, nmax * nmax);
		fill(B, nmax * nmax);
		fill(C, nmax * nmax);

		/* warm-up */
		dgemm_col(nmax, (double (*)[])A, (double (*)[])B, (double (*)[])C);

		/* test matrix multiplication */
		double seconds = wall_time();
		dgemm_col(nmax, (double (*)[])A, (double (*)[])B, (double (*)[])C);
		seconds = wall_time() - seconds;

		/* append results to output file */
		fprintf(outfile, "%f,\n", seconds);

		/* deallocate memory */
		free(buf);

		return 0;
}