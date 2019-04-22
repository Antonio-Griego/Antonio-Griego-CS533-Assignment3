# Antonio-Griego-CS533-Assignment3

This is the GitHub code repository for Assignment 3 of CS 533, Experimental Methods in Computer Science.

## compiling and running code

The code I will be running will be in the code subfolder in this repository. It will contain benchmarking code written for C and Java and will be the code used to produce my experimental data.

### Java

I have placed all of my benchmarking code for Java in the code/Java directory. I have included a build_script.sh file to compile my code which you can run via the command line:
```
$ ./build_script.sh
```

To run the benchmark, simply run the generated Jar:
```
$ java -cp ./JavaBenchmark.jar JavaBenchmark
```
or run the included convenience script:
```
$ ./run_script.sh
```

If you are running these scripts on a Mac you may need to use the "bash" command before the script. If you are on Ubuntu make sure you give executable permission to the necessary files or folders with "chmod +x".

## sub modules

This repository makes use of Git sub modules to include code from two repositories:

- https://github.com/MartinThoma/matrix-multiplication.git
- https://github.com/gmfricke/CS533_Assignment3_Matmult.git

These code bases serve as starting points and source material for code that I will write and/or adapt.

When downloading and running code from this repository, it will be necessary to run the command
```
git submodule init
```
in order to initialize and downloaded the code from these submodules.