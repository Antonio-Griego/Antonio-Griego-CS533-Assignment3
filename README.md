# Antonio-Griego-CS533-Assignment3

This is the GitHub code repository for Assignment 3 of CS 533, Experimental Methods in Computer Science.

## sub modules

This repository makes use of Git sub modules to include code from two repositories:

- https://github.com/MartinThoma/matrix-multiplication.git
- https://github.com/gmfricke/CS533_Assignment3_Matmult.git

And to also include my Latex report and all associated files from:

- https://github.com/Antonio-Griego/Antonio-Griego-CS533-Assignment3-LATEX.git

The code bases serve as starting points and source material for code that I will write and/or adapt.

When downloading code from this repository, it will be necessary to run the command
```
git submodule init
```
in order to initialize and download the code from the submodules.

Please NOTE that these submodules are not intended to be compiled and run individually. They are included for reference and documentation only.

## compiling and running code

The code I will be running will be in the code subfolder in this repository. It will contain benchmarking code written for C and Java and will be the code used to produce my experimental data.

My benchmarking programs are super simple, they time a single multiplication of a 100 x 100 matrix. The intent is to run these programs many, many times to produce a data sample of run times.

The C benchmark creates and/or appends to "results_c.out" and the Java benchmark creates and/or appends to "results_java.out" within the code directories where they will be run.

### C

I have placed all of my benchmarking code for C in the code/C directory. You can use the included Makefile to compile the code with the command:
```
$ make
```
while in the C directory.

To run the benchmark, simple run the generated executable file:
```
$ ./benchmark_col
```

### Java

I have placed all of my benchmarking code for Java in the code/Java directory. I have included a build_script.sh file to compile my code which you can run via the command line:
```
$ bash ./build.sh
```

To run the benchmark, simply run the generated Jar:
```
$ java -cp ./JavaBenchmark.jar JavaBenchmark
```
or run the included convenience script:
```
$ bash ./run.sh
```

If you want to clean out the previously compiled files:
```
$ bash ./clean.sh
```

If you are running these scripts on a Mac you may need to use the "bash" command before the script. If you are on Ubuntu make sure you give executable permission to the necessary files or folders with "chmod +x".