# run the experiment for the C benchmark
cd C
make

# gather 1,000 data points
counter=1
while [ $counter -le 1000 ]
do
    # debugging output
    # echo C run $counter
    ./benchmark_col
    ((counter++))
done

cd ..

# run the experiment for the Java benchmark
cd Java
bash ./build.sh

# gather 1,000 data points
counter=1
while [ $counter -le 1000 ]
do
    # debugging output
    # echo Java run $counter
    bash ./run.sh
    ((counter++))
done

cd ..
