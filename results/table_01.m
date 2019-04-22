clear;

y1 = load('wheeler/results_c.csv');
y2 = load('mac/results_c.csv');
y3 = load('wheeler/results_java.csv');
y4 = load('mac/results_java.csv');

% An unexpected error seems to have occured with my timing functions; some
% of the values are negative!
y1 = y1(y1 >= 0.0);
y2 = y2(y2 >= 0.0);
y3 = y3(y3 >= 0.0);
y4 = y4(y4 >= 0.0);

m1 = mean(y1);
m2 = mean(y2);
m3 = mean(y3);
m4 = mean(y4);