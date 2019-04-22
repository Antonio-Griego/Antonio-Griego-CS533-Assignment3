# GCC Compiler Flags
CC = gcc
OPT = -O3 -mfpmath=sse -msse4.2 -g -funroll-all-loops -ftree-vectorize -ftree-slp-vectorize -fopenmp-simd -ftree-vectorizer-verbose=2
CFLAGS += -Wall -std=gnu11 -DGETTIMEOFDAY $(OPT) -I/opt/ohpc/pub/libs/gnu/gsl/2.4/include
LDLIBS = -L/opt/ohpc/pub/libs/gnu/gsl/2.4/lib -lgslcblas

targets = $(patsubst %,benchmark_%,col)
objects = benchmark.o $(patsubst %,dgemm_%.o,col)

.PHONY : default
default : all

.PHONY : all
all : $(targets)

objects : $(objects)

benchmark_% : benchmark.o
	$(CC) $(OPT) -o $@ $^ $(LDLIBS)

%.o : %.c
	$(CC) -c $(CFLAGS) $<

.PHONY : clean
clean:
	rm -f $(targets) $(objects) *.stdout

%.o : %.c
	$(CC) -c $(CFLAGS) $<
