clear;

x1 = load('wheeler/results_c.csv');
x2 = load('mac/results_c.csv');
x3 = load('wheeler/results_java.csv');
x4 = load('mac/results_java.csv');

boxplot([x1, x2], 'Notch', 'on', 'Labels', ...
    {'Wheeler','My Mac'}, 'Whisker', 20);

ylim([0.004 0.016]);

ylabel('run time (seconds)', 'FontSize', 28);
title('Programming Language: C', 'FontSize', 34);
set(gca, 'FontSize', 32);

figure;

boxplot([x3, x4], 'Notch', 'on', 'Labels', ...
    {'Wheeler','My Mac'}, 'Whisker', 0.2);

ylim([0.1 0.35]);

ylabel('run time (seconds)', 'FontSize', 28);
title('Programming Language: Java', 'FontSize', 34);
set(gca, 'FontSize', 32);
